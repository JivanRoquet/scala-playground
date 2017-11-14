object FileMatcher extends App {
  private def filesHere = (new java.io.File(".")).listFiles

  def filesMatching(matcher: String => Boolean) =
    filesHere.filter(f => matcher(f.getName))

  def filesStarting(query: String) =
    filesMatching(_.startsWith(query))

  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))

  def filesRegex(query: String) =
    filesMatching(_.matches(query))

  println(filesEnding(".scala").mkString("\n"))
}
