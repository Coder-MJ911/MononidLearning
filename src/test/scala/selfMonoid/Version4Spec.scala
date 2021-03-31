package selfMonoid

import helpers.Specification
import version.Version4._

class Version4Spec extends Specification{

  implicit val listFoldable: Foldable[List] = new Foldable[List] {
    override def foldleft[A](fa: List[A])(zero: A)(f: (A, A) => A): A =
      fa.foldLeft(zero)(f)
  }

  private val addMonoid: SelfMonoid[Int] = new SelfMonoid[Int] {
    override def zero: Int = 0
    override def combine(x: Int, y: Int): Int = x + y
  }

  "Version 4 with F replacing List" in {
    fold1(List(1, 2, 3, 4, 5), addMonoid) shouldEqual 15
  }

  "Version 4 with F replacing List with context bound" in {
    fold2(List(1, 2, 3, 4, 5))(addMonoid) shouldEqual 15
  }

}
