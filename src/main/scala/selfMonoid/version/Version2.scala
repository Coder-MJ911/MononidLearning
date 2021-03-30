package selfMonoid.version

import selfMonoid.SelfMonoid

object Version2 {
  def fold(list: List[Int], m: SelfMonoid[Int]): Int = {
    list.foldLeft(m.zero)(m.combine)
  }

  def main(args: Array[String]): Unit = {
    val addMonoid: SelfMonoid[Int] = new SelfMonoid[Int] {
      override def zero: Int = 0
      override def combine(x: Int, y: Int): Int = x + y
    }

    val multiMonoid: SelfMonoid[Int] = new SelfMonoid[Int] {
      override def zero: Int = 1
      override def combine(x: Int, y: Int): Int = x * y
    }
    println(fold(List(1, 2, 3, 4, 5), addMonoid))
    println(fold(List(1, 2, 3, 4, 5), multiMonoid))
  }
}
