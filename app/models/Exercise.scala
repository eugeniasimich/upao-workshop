package models

import play.twirl.api.Html

import scala.util.{ Try, Success, Failure }

object Exercise {

  sealed abstract class Exercise(val title: String, val description: Html, val customInput: Boolean, val testInput: String => Try[String])

  case object Exercise1 extends Exercise("Revert a list",
    Html("""
      | Given a list of integers, revert it.
      |
  """.stripMargin),
    false,
    { input: String =>
      import exercises.Ex1Revert
      Try {
        val list: List[Int] = input.split(",").toList.map(_.toInt)
        Ex1Revert.revert(list).toString
      }
    }
  )

  case object Exercise2 extends Exercise("Another ex",
    Html("""
           | This one uses an input from the code.
           |
  """.stripMargin),
    true,
    { _ =>
      import exercises.Ex2Filter
      Try {
        Ex2Filter.filterList(Ex2Filter.customInput)
      }
    }
  )

  case object Exercise3 extends Exercise("This is a title",
    Html("""
           | This is a description.
           | It can include html: <strong>test </strong>
           |
  """.stripMargin),
    true,
    _ => Failure(new Exception("EXERCISE NOT IMPLEMENTED"))
  )

  case object Exercise4 extends Exercise("This is a title",
    Html("""
           | This is a description.
           | It can include html: <strong>test </strong>
           |
  """.stripMargin),
    true,
    _ => Failure(new Exception("EXERCISE NOT IMPLEMENTED"))
  )

  def listOfExercises: List[Exercise] = List(
    Exercise1, Exercise2, Exercise3, Exercise4
  )

}
