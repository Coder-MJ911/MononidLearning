package selfMonoid

trait SelfSemiGroup[A] {
  def combine(x: A, y: A): A
}
