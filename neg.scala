object Neg extends App {
  def containsNeg(nums: List[Int]): Boolean =
    nums.exists(_ < 0)
  def containsOdd(nums: List[Int]): Boolean =
    nums.exists(_ % 2 != 0)

  println(containsNeg(List(1, 2, 3, 4, 5)))
  println(containsOdd(List(-1, 2, 3, 4, 5)))
  println(containsOdd(List(2, 4, 6, 8, 10)))
}
