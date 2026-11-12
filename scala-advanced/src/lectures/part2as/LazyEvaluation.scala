package lectures.part2as

object LazyEvaluation extends App {
  // lazy DELAYs the evaluation of values
  lazy val x: Int = throw new RuntimeException

  lazy val y: Int = {
    println("hello")
    42
  }
  println(y) // evaluated once, for the first time, hello is only ever printed once
  println(y) // then, keep its return

  // Examples of implications

  // Example 1: Side-effects
  private def sideEffectCondition: Boolean = {
    println("Boo")
    true
  }

  private def simpleCondition: Boolean = false

  private lazy val lazyCondition = simpleCondition // Not evaluated UNLESS IT IS REALLY NEEDED
  println(if (simpleCondition && lazyCondition) "yes" else "no")

  // Example 2: Conjunction with call by-name
  def byNameMethod(n: => Int): Int = n + n + n + 1
  def retrieveMagicValue = {
    // side-effect or long computation
    print("Waiting")
    Thread.sleep(1000)
    42
  }
  println(byNameMethod(retrieveMagicValue)) // 3 waitings... no sense to do that
  private def byNameMethodNew(n: => Int): Int = {
    // CALL BY NEED TECHNIQUE
    lazy val t = n // Only evaluated once
    t + t + t + 1
  }
  println(byNameMethodNew(retrieveMagicValue)) // only 1 waiting!!

  // Example 3: Filtering with Lazy vals
  def lessThan30(i: Int): Boolean = {
    println(s"$i is less than 30?")
    i < 30
  }
  def greaterThan20(i: Int): Boolean = {
    println(s"$i is greater than 20?")
    i > 20
  }

  // We go step-by-step
  val numbers = List(1, 25, 40, 5, 23)
  private val lt30 = numbers.filter(lessThan30) // List(1, 25, 5, 23)
  private val gt20 = lt30.filter(greaterThan20)
  println(gt20)

  //
  private val lt30Lazy = numbers.withFilter(lessThan30)
  private val gt20Lazy = lt30Lazy.withFilter(greaterThan20)
  println
  println(gt20Lazy) // We don't see any side-effects ??!!!?? What the heck
  gt20Lazy.foreach(println) // We do both filters AT THE SAME TIME DUE TO THE LAZY EVALUATION

  // for-comprehension use withFilter with guards
  for {
    a <- List(1, 2, 3) if a % 2 == 0 // Uses Lazy Vals!!!!
  } yield a + 1
  List(1, 2, 3).withFilter(_ % 2 == 0).map(_ + 1) // (withFilter, map) work together to give us a list of ints here
}