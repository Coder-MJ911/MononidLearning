package MonaidLearning

import cats.Monoid
import helpers.Specification

class Version4Spec extends Specification{
  /*
    Todo: Now that the Int type has been generalized to A by introducing type parameters,
     a simple idea is to generalize the List type through the type parameters again.
     This is the fold method can be transformed into the following.
   */
  object Version4 extends App{

/*      Todo: Compilation fails here, cause the F type does not have the foldleft method.
           def fold[F[_], A](list: F[A], monoid: Monoid[A]): A = {
              list.foldLeft(m.zero)(m.combine)
           }
*/
    trait Foldable[F[_]] {
      def foldleft[A](fa: F[A])(zero: A)(f: (A, A) => A): A
    }


    def fold1[F[_]: Foldable, A](list: F[A], monoid: Monoid[A])(implicit f: Foldable[F]): A = {
      f.foldleft(list)(monoid.empty)(monoid.combine)
    }

    def fold2[F[_]: Foldable, A](list: F[A])(monoid: Monoid[A]): A = {
      implicitly[Foldable[F]].foldleft(list)(monoid.empty)(monoid.combine)
    }

    def fold3[F[_]: Foldable, A: Monoid](list: F[A]): A = {
      val monoid = implicitly[Monoid[A]]
      val foldable = implicitly[Foldable[F]]
      foldable.foldleft(list)(monoid.empty)(monoid.combine)
    }

    def fold4[F[_], A](eva: F[A])(implicit monoid: Monoid[A], foldable: Foldable[F]): A = {
      foldable.foldleft(eva)(monoid.empty)(monoid.combine)
    }

    implicit val listFoldable: Foldable[List] = new Foldable[List] {
      override def foldleft[A](fa: List[A])(zero: A)(f: (A, A) => A): A = fa.foldLeft(zero)(f)
    }

    val addMonoid: Monoid[Int] = new Monoid[Int] {
      //Todo: In the addition of integers, the result of adding any number to 0 is itself
      override def empty: Int = 0
      override def combine(x: Int, y: Int): Int = x + y
    }

  }


  import Version4._
  "use implicit with F replacing List[]" in {
    fold1(List(1, 2, 3, 4, 5), addMonoid) shouldEqual 15
  }

  "use context bound with F replacing List[A]" in {
    fold2(List(1, 2, 3, 4, 5))(addMonoid) shouldEqual 15
  }

  "context bound to optimize other parameters of the method" in {
    fold3(List(1, 2, 3, 4, 5)) shouldEqual 15
  }

  "ultimate goal to use implicit with singleton" in {
    object MonoidInstance {
      implicit val addMonoid: Monoid[Int] = new Monoid[Int] {
        override def empty: Int = 0
        override def combine(x: Int, y: Int): Int = x + y
      }
    }
    object FoldableInstance {
      implicit val listFoldable: Foldable[List] = new Foldable[List] {
        override def foldleft[A](fa: List[A])(zero: A)(f: (A, A) => A): A =
          fa.foldLeft(zero)(f)
      }
    }

    import MonoidInstance._
    import FoldableInstance._
    fold4(List(1, 2, 3, 4, 5)) shouldEqual 15
    //Todo: The writing in this last version is very similar to the writing in the Cats library.
  }

}
