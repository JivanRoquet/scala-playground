object Table extends App {
  def makeRowSeq(row: Int) =
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }

  // returns a row as a string
  def makeRow(row: Int) = makeRowSeq(row).mkString

  // prints the table
  println((for (row <- 1 to 10) yield makeRow(row)).mkString("\n"))
}
