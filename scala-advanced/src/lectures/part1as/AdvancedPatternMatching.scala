package lectures.part1as

object AdvancedPatternMatching extends App {
  private val numbers = List(1)
  private val description = numbers match {
    case head :: Nil => s"The only element is $head"
    case _ => "different result"
  }
  println(description)

  // This above is a little bit of magic, we need to understand how it works behind the scenes
  class Person(val name: String, val age: Int) // How to make a class (not a case class) compatible with pattern matching

  object Person { // companion object that basically unwraps person + unapply method
    def unapply(person: Person): Option[(String, Int)] = Some((person.name, person.age))

    // we can also overload
    def unapply(age: Int): Option[String] = Some(if (age <= 18) "minor" else "major")
  }

  private val bob = new Person("Bob", 22)
  val greeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "I don't know what I am"
  }
  println(greeting)

  private val legalStatus = bob.age match {
    case Person(status) => s"My legal status is $status"
    case _ => "I don't know what is my legal status"
  }
  println(legalStatus)
  // Okay, so it isn't a case class, but it has a companion object + unapply method

  private object even {
    def unapply(arg: Int): Option[Boolean] = if (arg % 2 == 0) Some(true) else None
  }

  private object singleDigit {
    def unapply(arg: Int): Option[Boolean] = if (arg > -10 && arg < 10) Some(true) else None
  }

  // Example usage
  private val n: Int = 8
  private val mathProperty = n match {
    case singleDigit(_) => "one digt"
    case even(_) => "even"
    case _ => "no property"
  }
  println(mathProperty)

  // infix patterns
  case class Or[A, B](a: A, b: B) // it has its own unapply

  val either = Or(2, "two")
  val humanDescription = either match {
    case number Or string => s"$number is written as $string" // not really more readable, but okay....
  }
  println(humanDescription)

  // decomposing sequences //
  val vararg = numbers match {
    case List(1, _*) => "Starting with number 1"
  }

  abstract class MyList[+A] {
    def head: A = ???

    def tail: MyList[A] = ???
  }

  case object Empty extends MyList[Nothing]

  case class Cons[+A](override val head: A, override val tail: MyList[A]) extends MyList[A]

  object MyList {
    def unapplySeq[A](list: MyList[A]): Option[Seq[A]] =
      if (list == Empty) Some(Seq.empty)
      else unapplySeq(list.tail).map(list.head +: _)
  }

  val myList: MyList[Int] = Cons(1, Cons(2, Cons(3, Empty)))
  val decomposed = myList match {
    case MyList(1, 2, _*) => "Starting with 1, 2" // this is possible because unapplySeq[MyList[A]] returns Option[Seq[A]]
    // compiler looks at MyList and search for unapplySeq, AND WE WROTE ONE!
    case _ => "something else"
  }

  // custom return types for unapply //
  // NOT NECESSARY IT NEEDS TO `Option`
  // We just need to have defined `isEmpty: Boolean` and `get: Something`
  abstract class Wrapper[T] {
    def isEmpty: Boolean
    def get: T
  }

  object PersonWrapper {
    def unapply(person: Person) = new Wrapper[String] {
      def isEmpty = false
      def get: String = person.name
    }
  }

  println(bob match {
    case PersonWrapper(n) => s"My name is $n"
    case _ => "an alien"
  })
}
