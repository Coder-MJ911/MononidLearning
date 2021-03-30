package MonaidLearning

import cats.Monoid
import helpers.Specification

  /*
  Todo: Associative law: combine(x, combine(y, z)) = combine(combine(x, y), z)
    trait Semigroup[A] {
      def combine(x: A, y: A): A
    }

  Todo: The difference between Monoid and Semigroup is that Monoid has more zero than Semigroup.
    trait MonoidLearning[A] extends SemiGroup[A]{
      def zero:A
    }
 */

class Version2Spec extends Specification{

  object Version2 extends App {
    def fold(list: List[Int], m: Monoid[Int]): Int = {
      list.foldLeft(m.empty)(m.combine)
    }
  }

  "version 2 sum" in {
    val addMonoid: Monoid[Int] = new Monoid[Int]{
      //Todo: In the addition of integers, the result of adding any number to 0 is itself
      override def combine(x: Int, y: Int): Int = x + y
      override def empty: Int = 0
    }

    import Version2._
    fold(List(1,2,3,4,5), addMonoid) shouldEqual 15
  }

  "version 1 multi" in {
    val multiMonoid: Monoid[Int] = new Monoid[Int]{
      //Todo: In the multiplication of integers, the result of any number multiplied by 1 is itself
      override def empty: Int = 1
      override def combine(x: Int, y: Int): Int = x * y
    }

    import Version2._
    fold(List(1,2,3,4,5), multiMonoid) shouldEqual 120
  }

}
