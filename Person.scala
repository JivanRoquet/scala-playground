class Person(val firstName: String, val lastName: String) extends Ordered[Person] {
  def compare(that: Person) = {
    val lastNameComp = lastName.compareToIgnoreCase(that.lastName)
    if (lastNameComp != 0)
      lastNameComp
    else
      firstName.compareToIgnoreCase(that.firstName)
  }

  override def toString = s"$firstName $lastName"
}

object MergePerson extends App {
  def msort[T <: Ordered[T]](xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _)             => ys
        case (_, Nil)             => xs
        case (x :: xs1, y :: ys1) =>
          if (x < y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(ys), msort(zs))
    }
  }

  val persons = List(
    new Person("Jivan", "Roquet"),
    new Person("Gustavo", "Santos"),
    new Person("Fabio", "Kuhn"),
    new Person("Salvar", "Sigudarsson"),
    new Person("Edward", "Wright"),
    new Person("Pamela", "Munger"),
    new Person("Etienne", "Amic"),
    new Person("Jose", "Tumkaya"),
    new Person("Jakub", "Korzeniowski"),
    new Person("John-Robert", "Granell"),
  )

  val sortedPersons = msort(persons)
  println(sortedPersons.mkString("\n"))
}
