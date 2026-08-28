package lectures.part1as

import scala.util.Try

object DarkSugars extends App {
  //// #1. methods with single params ////
  def singleArgMeth(arg: Int): String = s"$arg little ducks"

  val description = singleArgMeth {
    42
  }

  val aTryInstance = Try { // very Java alike style!!
    // apply method with params
    throw new RuntimeException("Oops")
  }

  println(
    List(1, 2, 3).map {
      x => x + 1
    }
  )

  //// #2. single abstract method pattern ////
  trait Action {
    def act(x: Int): Int
  }

  val aInstance: Action = new Action {
    override def act(x: Int): Int = x + 1
  }

  val aInstanceFunky: Action = (x: Int) => x + 1 // allow this lambda to become the class, its the same thing as before.

  val aThread = new Thread {
    override def run(): Unit = println("hey hey")
  }

  val aThreadFunky = new Thread(() => println("hi")) // way shorter

  // This also works for abstract classes that have only ONE remaining method not implemented
  abstract class AnAbstractType {
    def implemented: Int = 23

    def f(a: Int): Unit
  }

  val anAbstractType: AnAbstractType = (a: Int) => println("yo")

  //// #3. :: and #:: are special methods ////

  // Something that ends in : says the method is right associative
  // scala spec defines that
  println(1 :: 2 :: List(4, 4, 6)) // this works and desugars to List(4, 5, 6).::(1).::(2)
  // the only reason it works is because the method :: ends in `:`. We can defines methods like that as well

  //// #4. Multi-word method naming ////
  class TeenGirl(name: String) {
    def `and then said`(gossip: String) = println(s"$name said $gossip")
  }
  val lilly = new TeenGirl("Lilly")

  lilly `and then said` "I love Scala" // perfectly accepted in scala, not very usual

  //// #5. infix types ////
  class Composite[A, B]
  val composite: Int Composite String = ??? // perfectly acceptable

  class -->[A, B]
  val towards: Int --> String = ??? // perfectly compilable code

  //// #6. update method ////

  // Also a special method, much like .apply()
  val anArray = Array(1, 2, 3)
  anArray(2) = 7 // re-written to anArray.update(2, 7)
  // very much used in mutable collections

  //// #7. Setters for mutable containers ////
  class Mutable {
    private var internalMember: Int = 0 // private for OO encapsulation
    def member = internalMember // getter kindof
    def member_=(value: Int): Unit = internalMember = value
  }

  val aMutableContainer = new Mutable
  aMutableContainer.member = 22 // rewritten as aMutableContainer.member_=(2)
}
