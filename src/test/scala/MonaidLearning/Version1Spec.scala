package MonaidLearning

import helpers.Specification

/*

  Todo: Requirement:
   Input a set of numbers and output the result of accumulate and multiplicative.
   For example, if the input is the five numbers 1, 2, 3, 4, 5
   then the result of the accumulate is 1+2+3+4+5=15,
   and the result of the multiplicative is 1 * 2 * 3 * 4 * 5 =120

 */

class Version1Spec extends Specification{

  object Version1 extends App {
    //Define how to add up the numbers in the set
    def sum(list: List[Int]): Int = {
      list.foldLeft(0)((res, a) => res + a)
    }
    //Define how to multiply the numbers in the set
    def multi(list: List[Int]): Int = {
      list.foldLeft(1)((res, a) => res * a)
    }
  }

  import Version1._
  "version 1 sum" in {
    sum(List(1, 2, 3, 4, 5)) shouldEqual 15
  }

  "version 1 multi" in {
    multi(List(1, 2, 3, 4, 5)) shouldEqual 120
  }

}
