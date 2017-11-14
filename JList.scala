package scala

abstract class JList[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: JList[T]

  override def toString = tail match {
    case JNil => s"$head"
    case _    => head + ", " + tail
  }

  def !:[U >: T](x: U): JList[U] = new scala.!:(x, this)

  def :!:[U >: T](other: JList[U]): JList[U] =
    if (other.isEmpty) this
    else other.head !: other.tail :!: this

  def length: Int =
    if (isEmpty) 0
    else 1 + tail.length

  def map[U](f: T => U): JList[U] =
    if (isEmpty) JNil
    else f(head) !: tail.map(f)
}

case object JNil extends JList[Nothing] {
  override def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("head of empty JList")
  def tail: JList[Nothing] = throw new NoSuchElementException("tail of empty JList")
  override def toString = ""
}

final case class !:[T](head: T, tail: JList[T]) extends JList[T] {
  override def isEmpty = false
}
