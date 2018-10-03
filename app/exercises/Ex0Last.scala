package exercises

object Ex0Last {

  def last(list: List[Int]): Option[Int] = {
    list match {
      case Nil => None
      case x :: Nil => Some(x)
      case x :: rest => last(rest)
    }
  }

}