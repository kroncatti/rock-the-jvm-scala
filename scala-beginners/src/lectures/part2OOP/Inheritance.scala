package lectures.part2OOP

object Inheritance extends App {

  // single class inheritance, only one class extended at a time
  class Animal {
    def eat(): Unit = println("nomnom")

    val creatureType = "wild"
  }

  class Cat extends Animal {
    def crunch(): Unit = {
      eat()
      println("crunchCrunch")
    }
  }

  val cat = new Cat;
  cat.crunch()

  // Constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // Overriding
  class Dog extends Animal {
    override val creatureType = "domestic"

    override def eat(): Unit = println("au au au")
  }

  val dog = new Dog
  dog.eat()
  println(dog.creatureType)

  // you can also do the following
  //  class Dog extends Animal(override val creatureType: String) {
  //    override val creatureType = "domestic"
  //    override def eat(): Unit = println("au au au")
  //  }
  // val dog = new Dog("flying_animal")

  // type substitution (broad polymorphism)
  private val unknownAnimal: Animal = new Dog
  unknownAnimal.eat()

  // overRIDING vs overLOADING

  // preventing overrides
  // `final` will not allow us to change stuff:
  // - use `final` on members;
  // - use `final` on entire classes;
  // - `sealed` the class: The sealed keyword means that all subclasses of the class must be defined in the same source file;
}
