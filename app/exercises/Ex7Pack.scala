package exercises

object Ex7Pack {

  def pack(list: List[Int]): List[List[Int]] = {
    list match {
      case Nil => Nil
      case x :: xs =>
        pack(xs) match {
          case Nil => List(List(x))
          case y :: ys =>
            if (y.contains(x))
              (x :: y) :: ys
            else
              List(x) :: y :: ys
        }
    }
  }

}
