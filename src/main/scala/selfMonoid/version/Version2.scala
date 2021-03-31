package selfMonoid.version

import selfMonoid.SelfMonoid

object Version2 {
  def fold(list: List[Int], m: SelfMonoid[Int]): Int = {
    list.foldLeft(m.zero)(m.combine)
  }
}
