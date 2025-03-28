package lectures.part2OOP

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static"), we use objects
  object Person { // type + its only instance
    // "static/class"-level functionality
    val N_EYES = 2
    def canFly: Boolean = false // we can define methods for objects

    // Factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  class Person(val name: String) {
    // instance-level functionality
  }
  // COMPANIONS PATTERN, object + class
  println(Person.N_EYES)
  println(Person.canFly)

  // Scala Object = Singleton instance!!!! By definition!!!!
  val mary = Person
  val john = Person
  println(mary == john)
  val maryC = new Person("Mary")
  val johnC = new Person("John")
  println(maryC == johnC)

  val bobbie = Person(maryC, johnC)
  println(bobbie)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit
}
