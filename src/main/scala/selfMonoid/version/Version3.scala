package selfMonoid.version

import selfMonoid.SelfMonoid

object Version3 {
  def fold[A](list: List[A], m: SelfMonoid[A]): A = {
    list.foldLeft(m.zero)(m.combine)
  }

}
