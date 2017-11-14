import CheckSumAcc.calculate

object Classes extends App {
  for (arg <- args)
    println(arg + ": " + calculate(arg))
}
