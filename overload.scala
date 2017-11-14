object Run {
  def addMe(x:Int, y:Int) = x + y
  def addMe(x:Double, y:Double) = x - y

  def main(args: Array[String]) = {
    println(addMe(3, 4))
    println(addMe(5.3, 2.1))
  }
}
