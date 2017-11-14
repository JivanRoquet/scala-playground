object Run extends App {
  implicit val suits = List("foo", "bar", "baz")
  def printMe(s: String) = println(s)

  printMe(0)
  printMe(1)
  printMe(2)
}
