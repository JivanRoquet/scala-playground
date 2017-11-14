object Merge extends App {
  def msort[T](lt: (T, T) => Boolean)(xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, _)        => ys
      case (_, Nil)        => xs
      case (x :: xs1, y :: ys1) =>
        if (lt(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }

    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(lt)(ys), msort(lt)(zs))
    }
  }

  val unsorted = List(19, 7, 15, 2, 5, 12, 6, 1, 13, 9, 11, 3, 16, 14, 8, 20, 4, 10, 17)
  val res = msort((x: Int, y: Int) => x < y)(unsorted)
  println(res mkString ", ")
}
