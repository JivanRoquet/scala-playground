object Fold {
  def foldl(l: List[Int])(i: Int)(op: (Int, Int) => Int): Int = l match {
    case x :: xs  => foldl(xs)(op(x, i))(op)
    case Nil      => i
  }

  def reverse[T](l: List[T]): List[T] = (List[T]() /: l)((ys, y) => y :: ys)

  def sum(a: Int, b: Int): Int = a + b

  def main(args: Array[String]) = {
    val l = List(1, 2, 3, 4, 5)
    val f = foldl(l)(0)(sum)
    println(f)

    val ml = List.range(1, 20)
    println(reverse(ml).mkString(" "))
  }
}
