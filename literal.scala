object Literal extends App {
  def add(x: Int, y: Int): Int = x + y
  def rem(x: Int, y: Int): Int = x - y
  def mul(x: Int, y: Int): Int = x * y

  def addRec(x: Int*): Int = x match {
    case x +: Nil => x
    case x +: xs  => x + addRec(xs: _*)
  }

  println(addRec(3)) // shouldBe 3
  println(addRec(3, 4)) // shouldBe 7
  println(addRec(3, 4, 5)) // shouldBe 12
  println(addRec(3, 4, 5, 7)) // shouldBe 19

  def applyFun(fun: (Int, Int) => Int, x: Int, y: Int): Int =
    fun(x, y)

  println(applyFun(add, 3, 4)) // shouldbe 7
  println(applyFun(rem, 10, 6)) // shouldbe 4
  println(applyFun(add, 10, 6)) // shouldbe 16
  println(applyFun(mul, 3, 5)) // shouldbe 15

  val mul3 = mul(3, _: Int)

  println(mul3(10)) // shouldBe 30
}
