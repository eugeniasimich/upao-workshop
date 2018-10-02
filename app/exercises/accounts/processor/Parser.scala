package exercises.accounts.processor

import exercises.accounts._
import scala.util.{ Failure, Success, Try }
case class WrongNumberOfArgumentsParsingException(line: String) extends Exception(s"Error on line parsing. Too few fields. $line")
case class ActionTypeDoesNotMatch(found: String) extends Exception(s"Unknown account type identifier $found")

object Parser {
  def parseDouble(s: String): Try[Double] = {
    Try(s.toDouble)
  }

  def parseActionType(s: String): Try[ActionType] = {
    s match {
      case "D" => Success(Deposit)
      case "W" => Success(Withdraw)
      case e => Failure(ActionTypeDoesNotMatch(e))
    }
  }

  def parseAccountNumber(s: String): Try[AccountNumber] = {
    val (bankId, accId) = s.splitAt(3)
    for {
      n <- Try(accId.toInt)
    } yield AccountNumber(bankId, n)
  }
}

