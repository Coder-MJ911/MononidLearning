package selfMonoid

import helpers.Specification
import selfMonoid.version.Version4.Foldable
import version.Version5._

class Version5Spec extends Specification{

  implicit val listFoldable: Foldable[List] = new Foldable[List] {
    override def foldleft[A](fa: List[A])(zero: A)(f: (A, A) => A): A = fa.foldLeft(zero)(f)
  }

  implicit val addMonoid: SelfMonoid[Int] = new SelfMonoid[Int] {
    override def zero: Int = 0
    override def combine(x: Int, y: Int): Int = x + y
  }

  implicit val setFoldable: Foldable[Set] = new Foldable[Set] {
    override def foldleft[A](fa: Set[A])(zero: A)(f: (A, A) => A): A = fa.foldLeft(zero)(f)
  }

  "Version 5 whole context bound" in {
    fold(List(1, 2, 3, 4, 5)) shouldEqual 15
  }

  "v" in {
    fold(Set(1, 2, 3, 4, 5, 6)) shouldEqual 21
  }

}
