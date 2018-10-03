package exercises

object Ex12Slice {

  def slice(list: List[Int], i: Int, j: Int): List[Int] = {
    list.drop(i).take(j - i)
  }

}
