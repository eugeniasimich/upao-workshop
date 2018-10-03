package exercises

object Ex4Reverse {

  def reverse(list: List[Int]): List[Int] = {
    list match {
      case Nil => Nil
      case x :: rest => reverse(rest) ++ List(x)
    }
  }

}