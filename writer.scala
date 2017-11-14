case class Writer[A](value:A, msg:String="") {
  def map[B](f: A => B): Writer[B] =
    Writer(f(value), msg)

  def flatMap[B](f: A => Writer[B]): Writer[B] = {
    val k = f(value)
    Writer(k.value, s"${msg},${k.msg}")
  }
}

object Run {
  def main(args:Array[String]) = {
    val res = for {
      x <- Writer(2, "init")
      a <- Writer(x+3, "plus3")
      b <- Writer(a+4, "plus4")
      c <- Writer(b*2, "times2")
      d <- Writer(c+5, "plus5")
      e <- Writer(d+1, "plus1")
    } yield e

    val res3 = Writer(2, "init")
      .flatMap(n => Writer(n+3, "plus3"))
      .flatMap(n => Writer(n*3, "times3"))

    println(res)
    println(res3)
  }
}
