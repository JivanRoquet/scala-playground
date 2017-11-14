object Lists extends App {
  def isort(l: List[Int]): List[Int] = l match {
    case Nil     => Nil
    case x :: xs => insert(x, isort(xs))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case Nil     => x :: Nil
    case y :: ys => if (x <= y) x :: xs
                    else y :: insert(x, ys)
  }

  val myList = List(4, 3, 9, 1, 2, 8, 6, 7, 5, 0)

  println(isort(myList))

  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case Nil => ys
    case x :: xx  => x :: concat(xx, ys)
  }

  val cl = concat(List(0, 1, 2, 3, 4), List(5, 6, 7, 8, 9, 10, 11))
  println(cl)

  def reverse[T](l: List[T]): List[T] = l match {
    case Nil => Nil
    case x :: xs => reverse(xs) ::: List(x)
  }

  println(reverse(cl))
}
