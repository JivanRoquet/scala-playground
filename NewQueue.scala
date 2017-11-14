class NQueue[+T] private (
  private[this] var leading: List[T],
  private[this] var trailing: List[T])
{
  private def mirror() =
    if (leading.isEmpty) {
      while (!trailing.isEmpty) {
        leading = trailing.head :: leading
        trailing = trailing.tail
      }
    }

  def head: T = {
    mirror()
    leading.head
  }

  def tail: NQueue[T] = {
    mirror()
    new NQueue(leading.tail, trailing)
  }

  def enqueue[U >: T](x: U) =
    new NQueue[U](leading, x :: trailing)

  override def toString: String =
    (leading ::: trailing.reverse).mkString(", ")
}

object NQueue {
  def apply[T](xs: T*) = new NQueue[T](xs.toList, Nil)
}
