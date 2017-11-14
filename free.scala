object Append {
  def appendTo(v: Option[Int], lst: List[Int]) = v match {
    case Some(i) => i :: lst
    case None    => lst
  }
}
