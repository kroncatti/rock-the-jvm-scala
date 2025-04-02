package lectures.part2OOP

object AbstractDataTypes extends App{
  // abstract class
  abstract class Animal {
    val creatureType: String
    def eat(): Unit
  }

  class Dog extends Animal {
    val creatureType: String = "Canine"
    override def eat(): Unit = println("au au au")
  }
  val dog = new Dog

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat(): Unit = println("RAW RAW")
    def eat(animal: Animal): Unit = println(s"I am a ${this.creatureType} I am eating ${animal.creatureType}")
  }
  // traits != abstract_classes
  // abstract_classes can also have real implementations! traits as well!!!
  // How are they different ?
  // 1 - Traits DO NOT have constructor params
  // 2 - You can only extend one class, but you can inherit multiple traits
  // 3 - traits = "behaviour/adjectives", abstract_class = "thing"
}
