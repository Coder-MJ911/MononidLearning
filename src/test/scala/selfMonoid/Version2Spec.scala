package selfMonoid

import helpers.Specification
import version.Version2._

class Version2Spec extends Specification{

  "version 2 sum" in {
    val addMonoid: SelfMonoid[Int] = new SelfMonoid[Int]{
      //Todo: In the addition of integers, the result of adding any number to 0 is itself
      override def combine(x: Int, y: Int): Int = x + y
      override def zero: Int = 0
    }

    fold(List(1,2,3,4,5), addMonoid) shouldEqual 15
  }

  "version 1 multi" in {
    val multiMonoid: SelfMonoid[Int] = new SelfMonoid[Int]{
      //Todo: In the multiplication of integers, the result of any number multiplied by 1 is itself
      override def zero: Int = 1
      override def combine(x: Int, y: Int): Int = x * y
    }

    fold(List(1,2,3,4,5), multiMonoid) shouldEqual 120
  }

}
