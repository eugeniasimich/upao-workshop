package exercises

object Ex9Decode {

  val customInput: List[(Int, Int)] = List((3, 1), (2, 2), (1, 3), (1, 4), (2, 5))

  def decode(list: List[(Int, Int)]): List[Int] = {
    for {
      (r, e) <- list
      _ <- 1 to r
    } yield e
  }

}
