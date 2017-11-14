package strict

object Strict {
  def if2[A](condition: Boolean, onTrue: => A, onFalse: => A): A =
    if (condition) onTrue else onFalse
}
