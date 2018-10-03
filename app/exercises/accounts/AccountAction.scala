package exercises.accounts

sealed abstract class ActionType
case object Deposit extends ActionType
case object Withdraw extends ActionType

case class AccountAction(
    accountNumber: AccountNumber,
    amount: Double,
    actionType: ActionType) {

  // Shows an AccountAction(AccountNumber(CTI, 2323234), 100, Deposit) as
  // "A deposit of $100 has been made to account CTI2323234"

  override def toString: String = {
    s"A ${if (actionType == Deposit) "deposit" else "withdraw"} of $amount has been made to account ${accountNumber.bankId}${accountNumber.accountId}"
  }

}