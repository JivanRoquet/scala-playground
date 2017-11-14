case class Person(name: String, isMale: Boolean, children: Person*)

object Run extends App {
  val lara = Person("Lara", false)
  val bob = Person("Bob", true)
  val george = Person("George", true, lara)
  val claudia = Person("Claudia", false, lara, bob)
  val clint = Person("Clint", true, george)
  val esther = Person("Esther", false, george)
  val mike = Person("Mike", true, claudia)
  val jane = Person("Jane", false, claudia)

  val persons = List(
    lara,
    bob,
    george,
    claudia,
    clint,
    esther,
    mike,
    jane
  )

  val mothersAndChildren = persons.filter(p => !p.isMale)
                                  .flatMap(p =>
                                      (p.children.map(c =>
                                          (p.name, c.name))))

  println("Version with map, flatMap, filter")
  for (mother <- mothersAndChildren)
    println(mother)

  val mothersAndChildren2 = for {
    p <- persons if !p.isMale
    c <- p.children
  } yield (p.name, c.name)

  println("Version with for")
  for (mother <- mothersAndChildren2)
    println(mother)
}
