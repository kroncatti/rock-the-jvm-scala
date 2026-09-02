package lectures.part1as

import scala.annotation.tailrec

object Recap extends App {
  val aCondition: Boolean = false
  val aConditionVal = if (aCondition) 42 else 32
  // Instructions VS Expressions

  // Compiler infers types for us
  val aCodeBlock = {
    if (aCondition) 43 else 0
    56
  }

  // Unit --> Not returning something useful but do side-effects
  val theUnit = println("Hello Scala")

  // functions
  def aFunction(x: Int): Int = x + 1

  // recursion: stack and tail
  @tailrec
  def factorial(n: Int, acc: Int): Int =
    if (n <= 0) acc else factorial(n - 1, n * acc)

  //// object orientation
  class Animal

  class Dog extends Animal

  val aDog: Animal = new Dog // subtyping polymorphism

  trait Carnivore {
    def eat(a: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override def eat(a: Animal): Unit = println("Crunch crunch!")
  }

  val aAcroc = new Crocodile
  aAcroc.eat(aDog)
  aAcroc eat aDog // infix notation

  // many operators in Scala are actually methods

  // anonymous classes
  val aCarnivore = new Carnivore {
    override def eat(a: Animal): Unit = println("Roar roar!")
  }

  // generics
  abstract class MyList[+A] // variance and variance problems in depth
  // singleton and companions
  object MyList

  // case classes
  case class PersonOld(name: String, age: Int) // serializable, parameters are fields, apply methods, etc.

  // exceptions --> try/catch/finally
  // val throwsException = throw new RuntimeException // Nothing
  val aPotentialFailure = try {
    throw new RuntimeException("Boom!")
  } catch {
    case e: Exception => println("I am here")
  } finally {
    print("Logs")
  }

  // packaging and imports

  // Every single peace of code is either in a class or an object

  // functional programming
  // functions are instances of classes with an apply method
  val incrementer = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }

  println(incrementer(2))
}
