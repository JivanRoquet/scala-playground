trait Queue[T] {
  def head: T
  def tail: Queue[T]
  def enqueue(x: T): Queue[T]
}

object Queue {
  def apply[T](xs: T*): Queue[T] =
    new QueueImp[T](xs.toList, Nil)

  private class QueueImp[T](private val leading: List[T],
                            private val trailing: List[T]) extends Queue[T] {
    def mirror =
      if (leading.isEmpty)
        new QueueImp(trailing.reverse, Nil)
      else
        this

    def head: T = mirror.leading.head

    def tail: QueueImp[T] = {
      val q = mirror
      new QueueImp(q.leading.tail, q.trailing)
    }

    def enqueue(x: T) =
      new QueueImp(leading, x :: trailing)

    override def toString(): String =
      (leading ::: trailing.reverse).mkString(", ")
  }
}

object Run extends App {
  val q = Queue(1, 2, 3, 4, 5)
  println(q)
  val q2 = q.enqueue(9)
  println(q2)
}
