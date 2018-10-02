package exercises.accounts.processor

import exercises.accounts.AccountAction

import scala.util.Try

case class RawAccountAction(_accountNumber: String, _actionType: String, _amount: String) {
  import Parser._
  def parseLine: Try[AccountAction] = {
    ???
  }
}