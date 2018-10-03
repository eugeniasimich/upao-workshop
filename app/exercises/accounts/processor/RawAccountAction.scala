package exercises.accounts.processor

import exercises.accounts.AccountAction

import scala.util.Try

case class RawAccountAction(_accountNumber: String, _actionType: String, _amount: String) {
  import Parser._
  def parseLine: Try[AccountAction] = {
    for {
      acc <- parseAccountNumber(_accountNumber)
      act <- parseActionType(_actionType)
      amount <- parseDouble(_amount)
    } yield AccountAction(acc, amount, act)
  }
}