package exercises

object Ex8Encode {

  import exercises.Ex7Pack.pack
  def encode(list: List[Int]): List[(Int, Int)] = {
    val packList = pack(list)
    packList.map(l => (l.length, l.head))
  }

}
