package exercises

object Ex1LastTwo {

  def lastTwo(list: List[Int]): Option[List[Int]] = {
    list match {
      case Nil => None
      case x :: Nil => None
      case x :: y :: Nil => Some(list)
      case x :: rest => lastTwo(rest)
    }

  }

}