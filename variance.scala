package variance

object Variance {
  def mean(xs: List[Double]): Option[Double] = xs match {
    case Nil    => None
    case x :: _ => Some(xs.sum / xs.length)
  }

  def variance(xs: List[Double]): Option[Double] =
    mean(for {
      x <- xs
      m <- mean(xs)
    } yield math.pow(x - m, 2))

  def safeDiv(x: Int, y: Int): Either[Exception, Int] =
    try Right(x / y)
    catch { case e: Exception => Left(e) }
}

object Run {
  def main(args: Array[String]) = {
    val l1 = List(1D, 4D, 2D, 9D, 3D, 6D, 4D)
    val l2 = List(5D, 4D, 4D, 5D, 4D, 5D, 4D)
    val l3 = List(1D, 9D, 9D, 1D, 9D, 2D, 9D)
    val l4 = List[Double]()

    List(l1, l2, l3, l4).foreach { l =>
      println(f"mean: ${Variance.mean(l).getOrElse(Double.NaN)}%2.2f – variance: ${Variance.variance(l).getOrElse(Double.NaN)}%2.2f")
    }
  }
}
