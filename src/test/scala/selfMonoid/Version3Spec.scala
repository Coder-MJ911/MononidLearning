package selfMonoid

import helpers.Specification
import version.Version3._

class Version3Spec extends Specification{

  "implement a Monoid instance related to String concat" in {

    val stringMonoid: SelfMonoid[String] = new SelfMonoid[String]{
      override def zero: String = ""
      override def combine(x: String, y: String): String = x concat y
    }

    val result = fold[String](List("Jingjun","Qilin","Hongxing","Xiaonan","Yunpeng","Yinjun","Jiajie"), stringMonoid)
    result shouldEqual "JingjunQilinHongxingXiaonanYunpengYinjunJiajie"
  }

}
