package selfMonoid

trait SelfMonoid[A] extends SelfSemiGroup[A] {
  def zero: A
}
