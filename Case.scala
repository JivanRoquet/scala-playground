abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

case class Fruit(name: String)
case class Basket(fruits: List[Fruit])

object CaseClass extends App {
  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e))    => e
    case BinOp("+", e, Number(0))   => e
    case BinOp("*", e, Number(1))   => e
    case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
    case _                          => expr
  }

  // let's instantiate some dummy objects
  val v = Var("This is it!")
  val u = UnOp("-", UnOp("-", v))
  println(s"Before simplification: $u")

  // and now simplify
  val s = simplifyTop(u)
  println(s"After simplification: $s")

  // test guarded pattern
  val m = BinOp("+", Var("Yolo"), Var("Yolo"))
  val sm = simplifyTop(m)
  println(sm)

  val capitals = Map(
    "France" -> "Paris",
    "Japan" -> "Tokyo",
    "China" -> "Beijin"
  )

  println(capitals get "France")
  println(capitals get "Germany")

  def showCapital(x: Option[String]) = x match {
    case Some(s) => s"found $s"
    case None    => "nothing found here"
  }

  println(showCapital(capitals get "France"))
  println(showCapital(capitals get "China"))
  println(showCapital(capitals get "Germany"))

  val myBasket = Basket(List(
    Fruit("orange"),
    Fruit("apple"),
    Fruit("pear")
  ))

  val yourBasket = Basket(List(
    Fruit("pear")
  ))

  val hisBasket = Basket(List(
    Fruit("orange"),
    Fruit("kiwi")
  ))

  val herBasket = Basket(List(
    Fruit("apple"),
    Fruit("nectarine")
  ))

  println(myBasket)

  def howManyFruits(basket: Basket): String = basket match {
    case Basket(_ :: _ :: _ :: _ :: _)   => "Many fruits"
    case Basket(_ :: _ :: _ :: Nil)      => "Three fruits"
    case Basket(_ :: _ :: Nil)           => "Two fruits"
    case Basket(_ :: Nil)                => "One fruit"
    case Basket(Nil)                     => "No fruit"
  }

  println(s"There are ${howManyFruits(myBasket)} in my basket")

  val allBaskets = List(myBasket, yourBasket, hisBasket, herBasket)

  // looping through two-fruits baskets only
  for (Basket(_ :: b :: Nil) <- allBaskets) {
    println(s"This basket's second fruit is a ${b.name}")
  }

  val myList = List(
    List(1, 2, 3, 4, 5),
    List(11, 12, 13),
    List(1, 2, 3),
    List(101, 102, 103),
    List(1001, 1002, 1003, 1004, 1005),
    List(91, 92, 93)
  )

  for (_ :: b :: _ :: Nil <- myList) println(b)
}
