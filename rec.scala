object Run extends App {
  val points = Vector(15, 16, 17, -17, -16, -15, -16, -17, 16, 15, 14, 13, 14, 15, 16, 17, -17, -16)

  private def correctPathPoints(pts:Vector[Int], jump:Int=0): Vector[Int] = pts match {
    case p1 +: Vector() => Vector(p1 + jump * 36)
    case p1 +: ps if (p1 - ps.head) > +32 => (p1 + jump * 36) +: correctPathPoints(ps, jump+1)
    case p1 +: ps if (p1 - ps.head) < -32 => (p1 + jump * 36) +: correctPathPoints(ps, jump-1)
    case p1 +: ps => (p1 + jump * 36) +: correctPathPoints(ps, jump=jump)
  }

  val newPoints = correctPathPoints(points)
  println(points.map(p => f"${p}%4d"))
  println(newPoints.map(p => f"${p}%4d"))
}
