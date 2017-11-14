object Run extends App {
  case class Coordinates(lat: Double, lon: Double) {
    override def toString: String = s"$lat, $lon"

    // simple addition
    def +(that: Coordinates): Coordinates =
      this.lat + that.lat !> this.lon + that.lon

    // distance
    def Δ(that: Coordinates): Double =
      math.sqrt(math.pow(this.lat - that.lat, 2) + math.pow(this.lon - that.lon, 2))

    // barycentre
    def ∇(that: Coordinates): Coordinates = {
      val t = this + that
      (t.lat / 2) !> (t.lon / 2)
    }
  }

  implicit class MkCoordinates(lat: Double) {
    def !>(lon: Double) = Coordinates(lat, lon)
  }

  // let's create some coordinates
  val r = 34.21 !> 21.12
  val s = 32.46 !> 23.19

  // now we add them together
  val t = r + s
  println(t)

  // and we compute the distance between them
  var d = r Δ s
  println(d)

  // finally let's find their barycentre
  var b = r ∇ s
  println(b)
}
