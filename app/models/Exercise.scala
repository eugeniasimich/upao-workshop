package models

import play.twirl.api.Html

import scala.util.{ Try, Success, Failure }

object Exercise {

  sealed abstract class Exercise(val title: String,
    val description: Html,
    val nArgs: Int,
    val testInput: List[String] => Try[String])

  case object Exercise0 extends Exercise("Revert a list",
    Html("""
      | Given a list of integers, revert it.
      |
  """.stripMargin),
    1,
    { input: List[String] =>
      import exercises.Ex0Revert
      Try {
        val aInput = input.head
        val list: List[Int] = aInput.split(",").toList.map(_.toInt)
        Ex0Revert.revert(list).toString
      }
    }
  )

  case object Exercise1 extends Exercise("Another ex",
    Html("""
           | This one uses an input from the code.
           |
  """.stripMargin),
    0,
    { _ =>
      import exercises.Ex1Filter
      Try {
        Ex1Filter.filterList(Ex1Filter.customInput)
      }
    }
  )

  def listOfExercises: List[Exercise] = List(
    Exercise0, Exercise1
  )

}
