import scala.collection.mutable

object hello extends App {
  val first = List(1, 2, 3, 4)
  val second = List(7, 8, 9, 10)
  val third = first ::: second

  println(0 :: third)
  println(0 :: third)

  val out = third.mkString(", ")
  println(out)

  val pair = (99, "coucou")
  println(pair._1)
  println(pair._2)

  val lot = List(
    (99, "coucou"),
    (98, "hello"),
    (97, "cheese"),
    (96, "scandalous"),
  )
  println(lot.tail)

  println("------------")

  val treasureMap = mutable.Map[String, String]()
  treasureMap += ("intro" -> "go to island")
  treasureMap += ("first" -> "pick a spot")
  treasureMap += ("second" -> "dig a hole")
  treasureMap += ("third" -> "profit")
  println(treasureMap("second"))

  val greetings = Map[String, String](
    ("English" -> "Hello"),
    ("French" -> "Bonjour"),
    ("Spanish" -> "Hola"),
    ("Russian" -> "Привет"),
    ("German" -> "Güten Tag")
  )
  println(greetings("Russian"))
}
