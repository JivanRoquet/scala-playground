trait LazyRationalTrait {
  val numerArg: Int
  val denomArg: Int
  lazy val numer = { println("init numer"); numerArg / g }
  lazy val denom = { println("init denom"); denomArg / g }
  override def toString = { println("run toString"); s"$numer/$denom" }

  private lazy val g = {
    require(denomArg != 0)
    println("init g")
    gcd(numerArg, denomArg)
  }

  private def gcd(a: Int, b: Int): Int = {
    println("run gcd")
    if (b == 0) a else gcd(b, a % b)
  }
}

object Demo extends App {
  val x = 2

  val rationalNumber = new LazyRationalTrait {
    val numerArg = 1 * x
    val denomArg = 2 * x
  }

  println(rationalNumber)
}
