package selfMonoid.version

import selfMonoid.SelfMonoid

object Version3 {
  def fold[A](list: List[A], m: SelfMonoid[A]): A = {
    list.foldLeft(m.zero)(m.combine)
  }
  val stringMonoid: SelfMonoid[String] = new SelfMonoid[String] {
    override def zero: String = ""
    override def combine(x: String, y: String): String = x concat y
  }

  def main(args: Array[String]): Unit = {
    println(fold[String](List("Jingjun","Qilin","Hongxing","Xiaonan","Yunpeng","Yinjun","Jiajie"), stringMonoid))
  }
}
