trait Functor F[_] {
  def map[A,B](fa: F[A], f: A => B): F[B]
}

trait Monad M[_] {
  def flatmap[A,B](ma: M[A], f: A => M[B]): M[B]
}
