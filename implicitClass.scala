object Run {
  implicit class Hey(t: (List[Int], List[Int])) {
    def sum(): (Int, Int) =
      (t._1.sum, t._2.sum)
  }

  def main(args: Array[String]) = {
    val thing = List((1, 9), (2, 9), (3, 10), (2, 11), (1, 8)).unzip
    println(thing.sum)
  }
}
