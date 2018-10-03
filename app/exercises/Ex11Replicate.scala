package exercises

object Ex11Replicate {

  def replicate(list: List[Int], times: Int): List[Int] = {
    for {
      x <- list
      _ <- 1 to times
    } yield x
  }

}
