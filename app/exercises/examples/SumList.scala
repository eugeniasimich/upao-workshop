package exercises.examples

object SumList {

  //recursive and iterative version of a function to compute the sum of a list of integers

  def recursiveSum(list: List[Int]): Int = {
    list match {
      case Nil => 0
      case n :: rest => n + recursiveSum(rest)
    }
  }

  def iterativeSum(list: List[Int]): Int = {
    var sum = 0
    var i = 0
    while (i < list.length) {
      sum += list(i)
      i += 1
    }
    sum
  }
}