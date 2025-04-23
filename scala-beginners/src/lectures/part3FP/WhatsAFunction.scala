package lectures.part3FP

object WhatsAFunction extends App {

  // Use functions as first class elements

  // Doubler acts like a function, even though it is defined as a class/trait
  private val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  // You invoke it like a function, as the apply method is called;
  println(doubler(2))

  // function types = Function1[A, B] => Up to 22 parameters
  private val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }
  println(stringToIntConverter("3") + 4)

  private val adder = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }
  println(adder(4, 5))

  // ALL SCALA FUNCTIONS ARE OBJECTS BEHIND THE SCENES

  def concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  println(concatenator("Hello ", "Scala"))

  // higher order function
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adderThree = superAdder(3)
  println(adderThree(4))
  println(superAdder(3)(7))
}

trait MyFunction[A, B] {
  def apply(element: A): B
}