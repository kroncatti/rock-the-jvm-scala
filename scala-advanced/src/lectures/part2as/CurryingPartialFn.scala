package lectures.part2as

object CurryingPartialFn extends App {
  val superAdder: Int => Int => Int = x => y => x + y

  val add3 = superAdder(3) // Int => Int = y => 3 + y
  println(add3(5))

  private def curriedAdder(x: Int)(y: Int): Int = x + y // curried method

  private val added4: Int => Int = curriedAdder(4) // I cannot remove the type annotation, otherwise the compiler do not work
  // ETA-expansion (lifting)
  // functions != methods for the JVM

  private def inc(x: Int) = x + 1

  List(1, 2, 3).map(inc) // ETA-expansion --> Expanded as "x => inc(x)"

  // Partial function applications
  private val added5 = curriedAdder(5) _ // You are forcing the compiler to do the ETA expansion, then you don't really need the type annotation

  // EXERCISE
  private val simpleAddFunction = (x: Int, y: Int) => x + y
  private def simpleAddMethod(x: Int, y: Int): Int = x + y
  private def curriedAddMethod(x: Int)(y: Int): Int = x + y

  // implement added7 of type Int => Int = y => 7 + y out of each one of the simple adders above
  // be creative
  val functionAdded7: Int => Int = (y: Int) => simpleAddFunction(7, y)
  val functionAdded7New: Int => Int = simpleAddFunction(7, _)
  val functionAdded7New2 = simpleAddFunction.curried(7)

  val methodAdded7: Int => Int =  (y: Int) => simpleAddMethod(7, y)
  val methodAdded7New: Int => Int =  simpleAddMethod(7, _)
  val methodAdded7New2 =  simpleAddMethod(7, _: Int)

  val curryAdded7: Int => Int = curriedAddMethod(7)
  val curryAdded7New = curriedAddMethod(7) _
  val curryAdded7New2 = curriedAddMethod(7)(_)

  // underscores are powerful
  def concatenator(a: String, b: String, c: String) = a + b + c
  val insertName = concatenator("Hello, I'm ", _: String, ", how are you")
  println(insertName("Kaleb"))
}
