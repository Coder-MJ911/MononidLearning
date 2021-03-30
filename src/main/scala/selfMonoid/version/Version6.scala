package selfMonoid.version

import selfMonoid.SelfMonoid
import selfMonoid.version.Version4.Foldable

object Version6 {
  def fold[F[_], A](as: F[A])(implicit evf: Foldable[F], eva: SelfMonoid[A]): A = {
    evf.foldleft(as)(eva.zero)(eva.combine)
  }

  def main(args: Array[String]): Unit = {
    import helperInstance._

    println(fold(List(1, 2, 3, 4, 5)))
  }
}

object helperInstance {
  implicit val addMonoid: SelfMonoid[Int] = new SelfMonoid[Int] {
    override def zero: Int = 0
    override def combine(x: Int, y: Int): Int = x + y
  }

  implicit val foldable: Foldable[List] = new Foldable[List] {
    override def foldleft[A](fa: List[A])(zero: A)(f: (A, A) => A): A = fa.foldLeft(zero)(f)
  }
}