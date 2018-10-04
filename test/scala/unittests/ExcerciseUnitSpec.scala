package unittests

import exercises._
import org.scalatest.FlatSpec

class ExerciseUnitSpec extends FlatSpec {
  // ex 00
  "Ex0Last.last() " should "return the last element on the list" in {
    assert(Ex0Last.last(List(1, 2, 3, 4)) === Some(4))
  }

  // ex 01
  "Ex1LastTwo" should "return last element and penultimate" in {
    assert(Ex1LastTwo.lastTwo(List(1, 2, 3, 4)) === Some(List(3, 4)))
  }

  //ex 02
  "Ex2Nth" should "return the k'th element of a list" in {
    assert(Ex2Nth.nth(1, List(1, 2, 3)) === Some(2))
  }

  //ex 03
  "Ex3Length" should "return the length of a list" in {
    assert(Ex3Length.length(List(1, 2, 3)) === 3)
  }

  //ex 04
  "Ex4Reverse" should "return the reverse of a list " in {
    assert(Ex4Reverse.reverse(List(1, 2, 3, 4)) === List(4, 3, 2, 1))
  }

  //ex 05
  "Ex5Palindrome" should "return a true or false depend of this List is a palindrome" in {
    assert(Ex5Palindrome.palindrome(List(1, 2, 3, 2, 1)) === true)
  }

  //ex 06
  "Ex6Compress" should "return a list without consecutive duplicates of a list" in {
    assert(Ex6Compress.compress(List(1, 1, 2, 3, 4, 4, 4, 1, 1)) === List(1, 2, 3, 4, 1))
  }

  //ex 07
  "Ex7Pack" should "return a list with pack consecutive duplicates of a list into sublist" in {
    assert(Ex7Pack.pack(List(1, 1, 2, 3, 3, 4, 4, 4)) === List(List(1, 1), List(2), List(3, 3), List(4, 4, 4)))
  }

  //ex 08
  "Ex8Enconde" should "return length enconding of a list" in {
    assert(Ex8Encode.encode(List(1, 1, 1, 2, 2, 3, 4, 5, 5)) === List((3, 1), (2, 2), (1, 3), (1, 4), (2, 5)))
  }

  //ex 09
  "Ex09Decode" should "return decode a run-length encoded list" in {
    assert(Ex9Decode.decode(Ex9Decode.customInput) === List(1, 1, 1, 2, 2, 3, 4, 5, 5))
  }

  //ex 10
  "Ex10Duplicate" should "return a list with duplicate the elements of a list" in {
    assert(Ex10Duplicate.duplicate(List(1, 2, 3, 4, 4)) === List(1, 1, 2, 2, 3, 3, 4, 4, 4, 4))
  }

  //ex 11
  "Ex11Replicate" should "return a list with the elements of a list replicated given a number of times" in {
    assert(Ex11Replicate.replicate(List(1, 2, 3, 3), 2) === List(1, 1, 2, 2, 3, 3, 3, 3))
  }

  //ex 12
  "Ex12Extract" should "return a List with a slice from a list" in {
    assert(Ex12Slice.slice(List(1, 2, 3, 4, 5, 6), 2, 4) === List(3, 4))
  }

}