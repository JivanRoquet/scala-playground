object Curry extends App {
  def plainOldSum(x: Int, y: Int): Int = x + y
  def curriedSum(x: Int)(y: Int) = x + y
}
