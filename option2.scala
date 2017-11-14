package option2

import util.{Try, Success, Failure}

object Option2 {
  def seq[A](a: List[Option[A]]): Option[List[A]] =
    traverse(a)(n => n)

  def traverse[A,B](a: List[A])(f: A => Option[B]): Option[List[B]] =
    Try (a.map(x => f(x).get)) match {
      case Success(res) => Some(res)
      case Failure(_)   => None
    }
}
