import scala.io.Source

object hi extends App {
  val filename = "csv.scala"
  def wol(s: String) = s.length.toString.length
  val lines = Source.fromFile(filename).getLines().toList
  val longestLine = lines.reduceLeft(
    (a, b) => if (a.length > b.length) a else b
  )
  val maxWidth = wol(longestLine)
  for (line <- lines) {
    val numSpaces = maxWidth - wol(line)
    val padding = " " * numSpaces
    println(padding + line.length + " | " + line)
  }
}
