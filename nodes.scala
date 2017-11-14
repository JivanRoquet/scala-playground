class Graph(val nodes:Map[String,Node]) {
  def withNode(n:Node): Graph = {
    val newNodes = nodes ++ Map(n.p -> n)
    return Graph(newNodes)
  }

  def connect(from:String, to:String, cost:Int): Graph = {
    val nodeFrom = nodes.getOrElse(from, Node(from))
    val nodeTo = nodes.getOrElse(to, Node(to))
    val fromTo = Map(to -> cost)
    val toFrom = Map(from -> cost)
    return this.withNode(nodeFrom.withNeighboors(fromTo))
               .withNode(nodeTo.withNeighboors(toFrom))
  }

  def closestNodes(n:Node, nn:Map[String,Node]): List[Node] = {
    val nlist = nn.values.toList.sortWith(_.p < _.p)
    val i = (n :: nn.values.toList).sortWith(_.p < _.p).indexOf(n)
    val closest = List(nlist(i-1), nlist(i))
    println(n.p, closest.map(_.p))
    return closest
  }

  def connectEnd(p:String): Graph = {
    val newNode = nodes.getOrElse(p, Node(p))
    val closest: List[Node] = closestNodes(newNode, nodes)
    val newNodeConnected = newNode.withNeighboors(Map((for {
      c <- closest
    } yield (c.p -> 100)): _*))
    return closest.foldLeft(this) ((acc, n) => {
      val closestToNew = Map(newNode.p -> 100)
      acc.withNode(n.withNeighboors(closestToNew))
    }).withNode(newNodeConnected)
  }

  override def toString() = nodes.mkString("\n")
}

object Graph {
  def apply(nodes:Map[String,Node]=Map()) = new Graph(nodes)
}

class Node(val p:String, val neighboors:Map[String,Int]) {
  def withNeighboors(n:Map[String,Int]): Node = {
    val newNeighboors = neighboors ++ n
    return Node(p, newNeighboors)
  }

  override def toString() = neighboors.toString
}

object Node {
  def apply(p:String, n:Map[String,Int]=Map()) = new Node(p, n)
}

object Run extends App {
  val baseGraph = Graph().connect("foo", "bar", 34)
                         .connect("foo", "baz", 22)
                         .connect("bar", "bus", 11)
                         .connect("bar", "goo", 48)
                         .connect("mob", "goo", 20)
                         .connect("mob", "bus", 16)
                         .connect("zoo", "bar", 10)
                         .connect("mob", "wam", 13)

  val graph1 = baseGraph.connectEnd("chi")
                        .connectEnd("zhi")

  val graph2 = baseGraph.connectEnd("wey")
                        .connectEnd("ley")

  println(s"baseGraph before:\n${baseGraph}\n")
  println(s"graph1:\n${graph1}\n")
  println(s"graph2:\n${graph2}\n")
  println(s"baseGraph after:\n${baseGraph}\n")
}
