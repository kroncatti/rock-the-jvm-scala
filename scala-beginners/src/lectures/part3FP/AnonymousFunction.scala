package lectures.part3FP

object AnonymousFunction extends App {
  // syntactic sugar for all the .apply things we have
  val doubler = (x: Int) => 2 * x
  println(doubler(3))

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething = () => 3

  // more syntactic sugar
  val niceIncrementer: Int => Int = _ + 1
  val niceAdder: (Int, Int) => Int = _ + _

  val superAdderRefactor = (x: Int) => (y: Int) => x + y
  val testSuperAdderRefactor = superAdderRefactor(2)(4)
  println(testSuperAdderRefactor)
}
