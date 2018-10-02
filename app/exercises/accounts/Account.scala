package exercises.accounts

case class Account(
  accountNumber: AccountNumber,
  accountType: AccountType,
  value: Double,
  owner: Client)

case class AccountNumber(bankId: String, accountId: Int)

sealed abstract class AccountType
case object Checking extends AccountType
case object Savings extends AccountType

case class Client(name: String, surname: String, ssn: Int, email: String)

