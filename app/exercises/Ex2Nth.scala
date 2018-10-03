package exercises

object Ex2Nth {

  def nth(index: Int, list: List[Int]): Option[Int] = {
    (index, list) match {
      case (n, x :: _) if n == 0 => Some(x)
      case (n, x :: rest) if n > 0 => nth(n - 1, rest)
      case _ => None
    }
  }

}