package lectures.part2OOP

object Basics extends App {
  val person = new Person(name = "Kaleb", age = 26)
  person.greet("John")

  person.greetOther()
  person.greet("Joana", 27)
}

class Person(name: String, val age: Int = 0)  { // constructor
  // Class params ARE NOT fields! (e.g. name)
  // Unless you add a "val" before the parameter (e.g., age)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, ${name}")
  def greetOther(): Unit = println(s"Hi, I am ${this.name}!")

  // overloading
  def greet(name: String, age: Int): Unit = println(s"${this.name} says: Hi, ${name}! It's cool that you are ${age} years old.")

  // multiple constructors
  def this(name: String) = this(name = name, age = 0)
  def this() = this("John Doe")
}
