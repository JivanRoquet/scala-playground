object Run extends App {
  val integers = List(2, 3, 5, 4, 7, 9)
  val strings = List("hello", "HELLO", "hi", "HI", "foo", "FOO")

  val listOfBools = List(true, false, true, false, true, false, true, false, true, false)

  def even(x: Int): Boolean =
    x % 2 == 0

  def odd(x: Int): Boolean =
    !even(x)

  def lower(s: String): Boolean =
    s.toLowerCase == s

  def upper(s: String): Boolean =
    s.toUpperCase == s

  def comp[T](f: T => Boolean, l: List[T]): List[Boolean] =
    for (x <- l) yield f(x)

  println(comp(listOfBools, integers))
  println(comp(even, integers))
  println(comp(odd, integers))
  println(comp(lower, strings))
  println(comp(upper, strings))
}
