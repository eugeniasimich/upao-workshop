package exercises.accounts.processor

import Preprocessor._
import exercises.accounts.{ AccountAction, AccountNumber, ActionType, Withdraw }

object Processor extends App {
  implicit lazy val defaultConfig: Config = Config(filename = "actions.csv", separator = ",")

  def rawAccountActions: List[RawAccountAction] = readLines()
  def accountActions: List[AccountAction] =
    for {
      rawAction <- rawAccountActions
      action <- rawAction.parseLine.toOption
    } yield action

  def onlyCTIBank(allActions: List[AccountAction]): List[AccountAction] = {
    ???
  }

  def onlyWithdrawals(allActions: List[AccountAction]): List[AccountAction] = {
    ???
  }

  def actionsPerAccount(allActions: List[AccountAction]): Map[AccountNumber, Int] = {
    val actionMap: Map[AccountNumber, List[AccountAction]] = allActions.groupBy(_.accountNumber)
    actionMap.mapValues(???)
  }

  def accountSummary(allActions: List[AccountAction]): Map[AccountNumber, Map[ActionType, Double]] = {
    ???
  }

}

