package selfMonoid.version

import selfMonoid.SelfMonoid
import selfMonoid.version.Version4.Foldable

object Version5 {

  def fold[F[_]: Foldable, A: SelfMonoid](list: F[A]): A = {
    //We need local variables to facilitate our subsequent calls to the foldleft method
    val m = implicitly[SelfMonoid[A]]
    val f = implicitly[Foldable[F]]

    f.foldleft(list)(m.zero)(m.combine)
  }

  implicit val addMonoid: SelfMonoid[Int] = new SelfMonoid[Int] {
    override def zero: Int = 0
    override def combine(x: Int, y: Int): Int = x + y
  }

  def main(args: Array[String]): Unit = {
    println(fold(List(1, 2, 3, 4, 5)))
  }

}
