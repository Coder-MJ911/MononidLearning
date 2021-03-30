package selfMonoid.version

import selfMonoid.SelfMonoid

object Version4{
  //Todo: def fold[F[_],A](list: F[A], m: Monoid[A]): A = {
  //    Compilation fails here
  //    list.foldLeft(m.zero)(m.combine)
  // }

  trait Foldable[F[_]] {
    def foldleft[A](fa: F[A])(zero: A)(f: (A, A) => A): A
  }

  def fold1[F[_],A](list: F[A], m: SelfMonoid[A])(implicit foldable: Foldable[F]): A = {
    foldable.foldleft(list)(m.zero)(m.combine)
  }

  def fold2[F[_]: Foldable, A](list: F[A])(m: SelfMonoid[A]): A = {
    implicitly[Foldable[F]].foldleft(list)(m.zero)(m.combine)
  }

  implicit val listFoldable: Foldable[List] = new Foldable[List] {
    override def foldleft[A](fa: List[A])(zero: A)(f: (A, A) => A): A =
      fa.foldLeft(zero)(f)
  }

  private val addMonoid: SelfMonoid[Int] = new SelfMonoid[Int] {
    override def zero: Int = 0
    override def combine(x: Int, y: Int): Int = x + y
  }

  def main(args: Array[String]): Unit = {
    println(fold1(List(1, 2, 3, 4, 5), addMonoid))
    println(fold2(List(1, 2, 3, 4, 5))(addMonoid))
  }

}
