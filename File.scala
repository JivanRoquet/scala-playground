object FileSize extends App {
  val files = (new java.io.File(".")).listFiles

  def countLines(f: java.io.File): Int =
    scala.io.Source.fromFile(f).getLines().toList.length

  def countLinesAll(fs: Array[java.io.File]): Array[Int] =
    fs.withFilter(f => f.getName.endsWith(".scala")).map(f => countLines(f))

  val lines = countLinesAll(files)
  println(lines)
}
