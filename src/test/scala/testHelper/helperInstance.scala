package testHelper

import selfMonoid.SelfMonoid
import selfMonoid.version.Version4.Foldable

object helperInstance {
  implicit val addMonoid: SelfMonoid[Int] = new SelfMonoid[Int] {
    override def zero: Int = 0
    override def combine(x: Int, y: Int): Int = x + y
  }

  implicit val foldable: Foldable[List] = new Foldable[List] {
    override def foldleft[A](fa: List[A])(zero: A)(f: (A, A) => A): A = fa.foldLeft(zero)(f)
  }
}
