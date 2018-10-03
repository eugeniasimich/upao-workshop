package exercises

object Ex6Compress {

  def compress(list: List[Int]): List[Int] = {
    list match {
      case Nil => Nil
      case x :: Nil => list
      case x :: rest => {
        val rc = compress(rest)
        if (rc.head == x) rc else x :: rc
      }
    }
  }

}