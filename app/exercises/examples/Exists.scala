package exercises.examples

object Exists {

  //recursive and iterative version of a function to check if a list contains an element grater than x

  def recursiveExistsBiggerThan(list: List[Int], x: Int): Boolean = {
    list.exists(_ > x)
  }

  def iterativeExistsBiggerThan(list: List[Int], x: Int): Boolean = {
    var i = 0
    while (i < list.length) {
      if (list(i) > x) {
        return true
      }
    }
    return false
  }
}