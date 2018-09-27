package models

import play.twirl.api.Html

import scala.util.{ Try, Success, Failure }

object Exercise {

  sealed abstract class Exercise(val title: String,
    val description: Html,
    val nArgs: Int,
    val testInput: List[String] => Try[String])

  private def parseIntList(input: String) = input.split(",").toList.filter(_.nonEmpty).map(_.toInt)

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
  )

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
  )

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
  )

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
  )

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
  )

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
  )

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
  )

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
  )

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
  )

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
  )

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
  )

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
  )

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
  )

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
  )

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
    Exercise12
  )

}
