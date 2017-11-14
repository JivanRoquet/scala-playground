class Rational(n: Int, d: Int) {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val num = n / g
  val den = d / g

  def this(n: Int) = this(n, 1)

  def +(that: Rational): Rational =
    new Rational(
      num * that.den + that.num * den,
      den * that.den
    )

  def +(i: Int): Rational =
    new Rational(num + i * den, den)

  def -(that: Rational): Rational =
    new Rational(
      num * that.den - that.num * den,
      den * that.den
    )

  def -(i: Int): Rational =
    new Rational(num - i * den, den)

  def *(that: Rational): Rational =
    new Rational(num * that.num, den * that.den)

  def *(i: Int): Rational =
    new Rational(num * i, den)

  def /(that: Rational): Rational =
    new Rational(num * that.den, den * that.num)

  def /(i: Int): Rational =
    new Rational(num, den * i)

  override def toString = s"$num/$den"

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
