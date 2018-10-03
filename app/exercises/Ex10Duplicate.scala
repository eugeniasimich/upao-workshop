package exercises

object Ex10Duplicate {

  def duplicate(list: List[Int]): List[Int] = {
    list match {
      case Nil => Nil
      case x :: xs => x :: x :: duplicate(xs)
    }
  }

}
