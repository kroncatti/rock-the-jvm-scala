package lectures.part2OOP

object CaseClass extends App {
  case class Person(name: String, age: Int)
  // 1. class params becomes fields
  private val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  println(jim.toString)
  println(jim) // automatically uses toString = syntactic sugar

  // 3. equals and hashCode implemented out-of-the-box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2) // true, due to case class

  // 4. Case Classes have handy copy method
  val jim3 = jim.copy(age = 45)

  // 5. Case Classes have companion objects
  private val thePerson = Person
  val mary = thePerson.apply("Mary", 29)

  // 6. Case Classes are serializable, send in the network, example, when using Akka

  // 7. Case Classes have extractor patterns = Can be used in pattern matching

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

}
