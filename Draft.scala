class Food

abstract class Animal {
  type SuitableFood <: Food
  def eat(food: SuitableFood): String
}

class Grass extends Food
class Fish extends Food
class Meat extends Food

class Cow extends Animal {
  type SuitableFood = Grass
  override def eat(food: Grass): String = "mouh mouh"
}

class Horse extends Animal {
  type SuitableFood = Grass
  override def eat(food: Grass): String = "hihihihi"
}

class Lamb extends Animal {
  type SuitableFood = Grass
  override def eat(food: Grass): String = "behehehe"
}

class Cat extends Animal {
  type SuitableFood = Fish
  override def eat(food: Fish): String = "meow meow"
}

class Dog extends Animal {
  type SuitableFood = Meat
  override def eat(food: Meat): String = "whaf whaf"
}

class Barn {
  type GrassEater = Animal { type SuitableFood = Grass }
  val grass = new Grass
  var animals: List[GrassEater] = Nil

  def addAnimal(animal: GrassEater) =
    animals = animal :: animals

  def removeAnimal(): GrassEater = {
    val out = animals.head
    animals = animals.tail
    out
  }

  def feed(animal: GrassEater): String =
    animal eat grass

  def feedAnimals() =
    animals.map(feed).mkString(", ")

  override def toString(): String = animals.mkString(", ")
}

object Run extends App {
  val bessy = new Cow
  val pony = new Horse
  val bibi = new Lamb
  val grass = new Grass
  val kitkat = new Cat
  val fish = new Fish
  val doggy = new Dog
  val meat = new Meat

  println(bessy eat grass)
  println(kitkat eat fish)
  println(doggy eat meat)

  println("Putting grass eaters in the barn...")
  val barn = new Barn
  barn.addAnimal(bessy)
  barn.addAnimal(pony)
  barn.addAnimal(bibi)
  println("Feeding animals in the barn")
  println(barn.feedAnimals())
}
