package scala

abstract class NList[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: NList[T]

  override def toString: String = tail match {
    case NNil  => s"$head"
    case _     => s"$head, $tail"
  }

  def !!:[U >: T](x: U): NList[U] = new scala.!!:(x, this)

  def :!!:[U >: T](other: NList[U]): NList[U] =
    if (other.isEmpty) this
    else other.head !!: other.tail :!!: this

  def length: Int =
    if (isEmpty) 0
    else 1 + tail.length
}

case object NNil extends NList[Nothing] {
  override def isEmpty = true
  override def toString = ""
  def head: Nothing = throw new NoSuchElementException("head of empty NList")
  def tail: NList[Nothing] = throw new NoSuchElementException("tail of empty NList")
}

final case class !!:[T](head: T, tail: NList[T]) extends NList[T] {
  override def isEmpty = false
}
