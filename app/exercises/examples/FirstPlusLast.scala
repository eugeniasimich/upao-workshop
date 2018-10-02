package exercises.examples
import scala.util.{ Try, Success, Failure }
import java.util.NoSuchElementException

object FirstPlusLast {

  private def primero(list: List[Int]): Try[Int] = list match {
    case Nil => Failure(new NoSuchElementException)
    case n :: rest => Success(n)
  }

  private def ultimo(list: List[Int]): Try[Int] = list match {
    case Nil => Failure(new NoSuchElementException)
    case n :: Nil => Success(n)
    case n :: rest => ultimo(rest)
  }

  def primeroMasUltimo(list: List[Int]): Try[Int] =
    for {
      p <- primero(list)
      u <- ultimo(list)
    } yield p + u

}