package joption

import util.{Try, Success, Failure}

trait JOption[+A] {
  def isEmpty: Boolean
  def get: A

  def map[B](f: A => B): JOption[B] =
    if (isEmpty) XNone else XSome(f(this.get))

  def flatMap[B](f: A => JOption[B]): JOption[B] =
    if (isEmpty) XNone else f(this.get)

  def filter(f: A => Boolean): JOption[A] =
    if (!isEmpty && f(this.get)) XSome(this.get)
    else XNone

  def getOrElse[B >: A](e: => B): B =
    if (isEmpty) e else this.get

  def orElse[B >: A](e: => JOption[B]): JOption[B] =
    if (isEmpty) e else this
}

case class XSome[+A](element: A) extends JOption[A] {
  def isEmpty: Boolean = false
  def get: A = element
}

case object XNone extends JOption[Nothing] {
  def isEmpty: Boolean = true
  def get = throw new NoSuchElementException("None.get")
}

object JOption {
  def map2[A,B,C](a: JOption[A], b: JOption[B])(f: (A,B) => C): JOption[C] =
    for {
      aa <- a
      bb <- b
    } yield f(aa, bb)

  def lift[A,B](f: A => B): JOption[A] => JOption[B] =
    _ map f

  def seq[A](a: List[JOption[A]]): JOption[List[A]] =
    traverse(a)(n => n)

  def traverse[A,B](a: List[A])(f: A => JOption[B]): JOption[List[B]] =
    Try (a.map(x => f(x).get)) match {
      case Success(res) => XSome(res)
      case Failure(_)   => XNone
    }
}
