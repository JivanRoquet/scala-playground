class Mon[A](val a:A) {
  override def toString = s"Mon($a)"

  def get() = a

  def map[B](f: A => B): Mon[B] =
    Mon(f(a))

  def flatMap[B](f: A => Mon[B]): Mon[B] =
    f(a)
}

object Mon {
  def apply[A](a:A) = new Mon[A](a)
}

object Run extends App {
  def monTimesTwo(x: Int) = Mon(x * 2)
  def monPlus(x: Int)(y: Int) = Mon(x + y)

  val m = Mon(45)
  val n = m map (_ + 2)
  println(m)
  println(n)

  val o = monTimesTwo(3) flatMap monTimesTwo flatMap monTimesTwo
  println(o)

  val p = monPlus(5)(3)
  val q = p flatMap monPlus(3)
  println(q)
}
