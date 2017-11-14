import scala.annotation.tailrec

object Run {
  @tailrec def fillLine(o:List[Float], n:List[Float]=Nil): List[Float] = {
    if (o.length == 1) return (o.head :: n).reverse
    val (p1, p2) = (o.head, o.tail.head)
    if (p2 - p1 > 3)
      fillLine(p1 :: p1 + (p2 - p1) / 2 :: o.tail, n)
    else
      fillLine(o.tail, o.head :: n)
  }

  def main(args: Array[String]) = {
    val oldLine = List(1,2,3,6,7,14,18,20,22).map(_.toFloat)
    val newLine = fillLine(oldLine)
    println(newLine)
  }
}
