sealed trait PingType
case object StdPing extends PingType
case object ManPing extends PingType
case object OsmPing extends PingType
case class Ping(val id:Int, val kind:PingType)

object Run extends App {
  val p = Ping(id=32, kind=StdPing)
  val q = Ping(id=32, kind=ManPing)
  println(p)
  println(q)
}
