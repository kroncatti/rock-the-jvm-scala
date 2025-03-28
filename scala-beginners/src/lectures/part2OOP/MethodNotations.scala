package lectures.part2OOP

import scala.language.postfixOps

object MethodNotations extends App{
  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangsOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"${name}, what the heck!!!"

    def isAlive: Boolean = true

    // This is a special method!!!!!
    def apply(): String = s"Hi, my name is ${this.name} and I like the movie '${this.favoriteMovie}'"
  }

  val mary = new Person("Mary", "Inception")
  val john = new Person("John", "Fight Club")
  println(mary.likes("Inception"))

  // infix-notation, only objects that have one parameter! syntactic sugar!
  println(mary likes "Inception")

  // "Operators" in Scala
  println(mary hangsOutWith john) // 'hangsOutWith' could be renamed to '+'
  // Behind the scenes, all operators are methods in Scala

  // prefix-notation! syntactic sugar!
  val x = -1 // equivalent to 1.unary_-
  println(!mary)

  // postfix-notation, only available for methods with no params
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary())

}
