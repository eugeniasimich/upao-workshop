package exercises

object Ex3Length {

  def length(list: List[Int]): Int = {
    list match {
      case Nil => 0
      case x :: rest => 1 + length(rest)
    }
  }

}