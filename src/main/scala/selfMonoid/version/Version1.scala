package selfMonoid.version

object Version1 extends App {
  //Define how to add up the numbers in the set
  def sum(list: List[Int]): Int = {
    list.foldLeft(0)((res, a) => res + a) //Todo: list.sum is fine
  }
  //Define how to multiply the numbers in the set
  def multi(list: List[Int]): Int = {
    list.foldLeft(1)((res, a) => res * a) //Todo: list.product is fine
  }
  //Finally print the results in the console
  println(sum(List(1, 2, 3, 4, 5)))
  println(multi(List(1, 2, 3, 4, 5)))
}
