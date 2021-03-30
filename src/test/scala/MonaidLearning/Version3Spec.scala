package MonaidLearning

import cats.Monoid
import helpers.Specification

class Version3Spec extends Specification{

  //Todo: Observing the definition of the fold method in version2,
  // we can find that this version of the fold function can only handle a set of objects of type Int,
  // it is not competent for a set of objects of type Double or String,
  // so we need introduce the type parameter in scala to optimize it again, the optimized code is as follows.

  object Version3 extends App {
    def fold[A](list: List[A], m: Monoid[A]): A = {
      list.foldLeft(m.empty)(m.combine)
    }
  }

  "implement a Monoid instance related to String concat" in {

    val stringMonoid: Monoid[String] = new Monoid[String]{
      override def empty: String = ""
      override def combine(x: String, y: String): String = x concat y
    }

    import Version3._
    val result = fold[String](List("Jingjun","Qilin","Hongxing","Xiaonan","Yunpeng","Yinjun","Jiajie"), stringMonoid)
    result shouldEqual "JingjunQilinHongxingXiaonanYunpengYinjunJiajie"
  }


}
