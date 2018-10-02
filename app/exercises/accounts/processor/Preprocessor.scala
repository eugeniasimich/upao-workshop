package exercises.accounts.processor

import scala.io.Source.fromFile
import scala.util.{ Failure, Success, Try }

object Preprocessor {

  def readLines()(implicit config: Config): List[RawAccountAction] = {
    val lines: List[String] = fromFile("actions.csv").getLines.toList
    println("config:" + config.toString)
    for {
      line <- lines
      rawLine <- fromStringToRawLine(line)(config).toOption
    } yield rawLine
  }

  def fromStringToRawLine(string: String)(implicit config: Config): Try[RawAccountAction] = {
    val stringList: Array[String] = string.split(config.separator)
    stringList match {
      case Array(_accountNumber, _actionType, _amount) => Success(RawAccountAction(_accountNumber, _actionType, _amount))
      case _ => Failure(WrongNumberOfArgumentsParsingException(string))
    }

  }
}

case class Config(val filename: String, val separator: String)
