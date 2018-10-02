package models

import exercises.accounts.processor.{ Config, RawAccountAction }
import play.twirl.api.Html

import scala.util.{ Failure, Success, Try }

object Topic {

  abstract class Topic(val label: String)

  case object Lists extends Topic("Lists")

  case object AccountsSuite extends Topic("Accounts suite")

}
object Exercise {
  import Topic.{ Topic, Lists, AccountsSuite }

  sealed abstract class Exercise(val title: String,
      val description: Html,
      val nArgs: Int,
      val testInput: List[String] => Try[String]) {
    def topic: Topic
  }

  val l: List[Int] = List(1, 2, 3)
  private def parseIntList(input: String) = input.split(",").toList.filter(_.nonEmpty).map(_.toInt)
  private def parseStringList(input: String) = input.split(",").toList.filter(_.nonEmpty).map(s => s.replaceAll("\"", ""))

  case object ExerciseTemplate extends Exercise("Title",
    Html(
      """
        | Description
      """.stripMargin),
    0,
    { _ =>
      Try {
        ""
      }
    }
  ) { def topic: Topic = Lists }

  case object Exercise0 extends Exercise("Get the last element of a list (easy)",
    Html("""
      |Write a function <span class="monospace">last: List[Int] => Option[Int]</span> that returns the last element of a list. <br/>
      |e.g.:
      |<pre>
      |last(List(1, 2, 3, 4)) = Some(4)
      |last(List()) = None
      |</pre>""".stripMargin),
    1,
    { input: List[String] =>
      import exercises.Ex0Last
      Try {
        val list: List[Int] = parseIntList(input.head)
        Ex0Last.last(list).toString
      }
    }
  ) { def topic: Topic = Lists }

  case object Exercise1 extends Exercise("Find last element and penultimate (easy)",
    Html("""
     | Find the last but one (last and penultimate) elements of a list. <br/>
     | <pre>
     |lastTwo(List(1, 2, 3, 4)) = Some((1, 2))
     |lastTwo(List(1)) = None
     | </pre>""".stripMargin),
    1,
    { input =>
      import exercises.Ex1LastTwo
      Try {
        val list: List[Int] = parseIntList(input.head)
        Ex1LastTwo.lastTwo(list).toString
      }
    }
  ) { def topic: Topic = Lists }

  case object Exercise2 extends Exercise("Find the k'th element of a list. (easy)",
    Html(
      """
        | <pre>
        | nth(1, List(1, 2, 3)) = Some(2)
        | nth(3, List(1)) = None
        | </pre>
      """.stripMargin),
    2,
    { input =>
      import exercises.Ex2Nth
      Try {
        val index: Int = input.head.toInt
        val list: List[Int] = parseIntList(input.last)
        Ex2Nth.nth(index, list).toString
      }
    }
  ) { def topic: Topic = Lists }

  case object Exercise3 extends Exercise("Find the number of elements of a list. (easy)",
    Html(
      """
        | <pre>
        | length(List(1,2,3)) = 3
        | length(List()) = 0
        | </pre>
      """.stripMargin),
    1,
    { input =>
      import exercises.Ex3Length
      Try {
        val list: List[Int] = parseIntList(input.head)
        Ex3Length.length(list).toString
      }
    }
  ) { def topic: Topic = Lists }

  case object Exercise4 extends Exercise("Reverse a list. (easy)\n",
    Html(
      """
        | <pre>
        | reverse(List()) = List()
        | reverse(List(1, 2, 3, 4)) = List(4, 3, 2, 1)
        | </pre>
      """.stripMargin),
    1,
    { input =>
      import exercises.Ex4Reverse
      Try {
        val list: List[Int] = parseIntList(input.head)
        Ex4Reverse.reverse(list).toString
      }
    }
  ) { def topic: Topic = Lists }

  case object Exercise5 extends Exercise("Find out whether a list is a palindrome. (easy)",
    Html(
      """
        | <pre>
        | palindrome(List(1, 2, 3, 2, 1)) = True
        | palindrome(List(1, 2, 3)) = False
        | </pre>
      """.stripMargin),
    1,
    { input =>
      import exercises.Ex5Palindrome
      Try {
        val list: List[Int] = parseIntList(input.head)
        Ex5Palindrome.palindrome(list).toString
      }
    }
  ) { def topic: Topic = Lists }

  case object Exercise6 extends Exercise("Eliminate consecutive duplicates of list elements. (medium)",
    Html(
      """
        | <pre>
        | compress(List(1, 1, 2, 3, 4, 4, 4, 1, 1)) = List(1, 2, 3, 4, 1)
        | </pre>
      """.stripMargin),
    1,
    { input =>
      import exercises.Ex6Compress
      Try {
        val list: List[Int] = parseIntList(input.head)
        Ex6Compress.compress(list).toString
      }
    }
  ) { def topic: Topic = Lists }

  case object Exercise7 extends Exercise("Pack consecutive duplicates of list elements into sublists. (medium)",
    Html(
      """
        | <pre>
        | pack(List(1, 1, 2, 3, 3, 4, 4, 4)) = List(List(1, 1), List(2), List(3, 3), List(4, 4, 4))
        | </pre>
      """.stripMargin),
    1,
    { input =>
      import exercises.Ex7Pack
      Try {
        val list: List[Int] = parseIntList(input.head)
        Ex7Pack.pack(list).toString
      }
    }
  ) { def topic: Topic = Lists }

  case object Exercise8 extends Exercise("Run-length encoding of a list. (easy)",
    Html(
      """
        | <pre>
        | encode(List(1, 1, 1, 2, 2, 3, 4, 5, 5)) = List((3, 1), (2, 2), (1, 3), (1, 4), (2, 5))
        | </pre>
      """.stripMargin),
    1,
    { input =>
      import exercises.Ex8Encode
      Try {
        val list: List[Int] = parseIntList(input.head)
        Ex8Encode.encode(list).toString
      }
    }
  ) { def topic: Topic = Lists }

  case object Exercise9 extends Exercise("Decode a run-length encoded list. (medium)",
    Html(
      """
        | <pre>
        | decode(List((3, 1), (2, 2), (1, 3), (1, 4), (2, 5))) = List(1, 1, 1, 2, 2, 3, 4, 5, 5)
        | </pre>
        | This one uses a custom input that can be found in the exercise.
      """.stripMargin),
    0,
    { _ =>
      import exercises.Ex9Decode
      Try {
        Ex9Decode.decode(Ex9Decode.customInput).toString
      }
    }
  ) { def topic: Topic = Lists }

  case object Exercise10 extends Exercise("Duplicate the elements of a list. (easy)",
    Html(
      """
        | <pre>
        | duplicate(List(1, 2, 3, 4, 4)) = List(1, 1, 2, 2, 3, 3, 4, 4, 4, 4)
        | </pre>
      """.stripMargin),
    1,
    { input =>
      import exercises.Ex10Duplicate
      Try {
        val list: List[Int] = parseIntList(input.head)
        Ex10Duplicate.duplicate(list).toString
      }
    }
  ) { def topic: Topic = Lists }

  case object Exercise11 extends Exercise("Replicate the elements of a list a given number of times. (medium)",
    Html(
      """
        | <pre>
        | replicate(List(1, 2, 3, 3), 2) = List(1, 1, 2, 2, 3, 3, 3, 3)
        | </pre>
      """.stripMargin),
    2,
    { input =>
      import exercises.Ex11Replicate
      Try {
        val list: List[Int] = parseIntList(input.head)
        val times: Int = input.last.toInt
        Ex11Replicate.replicate(list, times).toString
      }
    }
  ) { def topic: Topic = Lists }

  case object Exercise12 extends Exercise("Extract a slice from a list. (medium)",
    Html(
      """
        | <pre>
        | slice(List(1, 2, 3, 4, 5, 6), 2, 4) = List(3, 4, 5)
        | </pre>
      """.stripMargin),
    3,
    { input =>
      import exercises.Ex12Slice
      Try {
        val list: List[Int] = parseIntList(input.head)
        val i: Int = input(1).toInt
        val j: Int = input(2).toInt
        Ex12Slice.slice(list, i, j).toString
      }
    }
  ) { def topic: Topic = Lists }

  case object ParseLine extends Exercise("Parse an account",
    Html(
      """
        | <pre>
        | RawAccountAction("CTI7209","D","1079.00").parseLine = AccountAction(AccountNumber(CTI,7209),Deposit,1079.0)<br>
        | <b>Example:</b> Use CTI7209,D,1079.00 in the input box above
        | </pre>
      """.stripMargin),
    1,
    { input =>
      import exercises.accounts.processor.Preprocessor._
      implicit lazy val defaultConfig: Config = Config(filename = "actions.csv", separator = ",")

      val maybeRawAccountAction: Try[RawAccountAction] = fromStringToRawLine(input.head)

      for {
        rawAccountAction <- maybeRawAccountAction
        action <- rawAccountAction.parseLine
      } yield action.toString
    }
  ) { override def topic: Topic = AccountsSuite }

  case object OnlyCTIBank extends Exercise("Filter by bank",
    Html(
      """
        | <pre>
        | "actions.csv" file will be parsed. Only show account numbers with bankId equal to "CTI"
        | </pre>
      """.stripMargin),
    0,
    { input =>
      import exercises.accounts.processor.Processor.{ onlyCTIBank, accountActions }
      Try(onlyCTIBank(accountActions).map(_.toString).mkString("\n"))

    }
  ) { override def topic: Topic = AccountsSuite }

  case object OnlyWithdrawals extends Exercise("Filter by type of action",
    Html(
      """
        | <pre>
        | "actions.csv" file will be parsed. Only return account withdrawals
        | </pre>
      """.stripMargin),
    0,
    { input =>
      import exercises.accounts.processor.Processor.{ onlyWithdrawals, accountActions }
      Try(onlyWithdrawals(accountActions).map(_.toString).mkString("\n"))
    }
  ) { override def topic: Topic = AccountsSuite }

  case object AccountActionsNumberPerAccount extends Exercise("Number of deposits and withdraws per account",
    Html(
      """
        | <pre>
        | "actions.csv" file will be parsed. Return the number of actions per account.
        | </pre>
      """.stripMargin),
    0,
    { input =>
      import exercises.accounts.processor.Processor.{ actionsPerAccount, accountActions }
      Try(actionsPerAccount(accountActions).map(_.toString).mkString("\n"))
    }
  ) { override def topic: Topic = AccountsSuite }

  case object AccountSummary extends Exercise("Account Sumary",
    Html(
      """
        | <pre>
        | "actions.csv" file will be parsed. Return, for each account, the total amount deposited and the total extracted
        | </pre>
      """.stripMargin),
    0,
    { input =>
      import exercises.accounts.processor.Processor.{ accountSummary, accountActions }
      Try(accountSummary(accountActions).map(_.toString).mkString("\n"))
    }
  ) { override def topic: Topic = AccountsSuite }

  def listOfExercises: List[Exercise] = List(
    Exercise0,
    Exercise1,
    Exercise2,
    Exercise3,
    Exercise4,
    Exercise5,
    Exercise6,
    Exercise7,
    Exercise8,
    Exercise9,
    Exercise10,
    Exercise11,
    Exercise12,
    ParseLine,
    OnlyCTIBank,
    OnlyWithdrawals,
    AccountActionsNumberPerAccount,
    AccountSummary
  )

}
