package lectures.part1Basics

object Expressions extends App {
  // basic operators
  private val x = 2 + 1
  println(x)

  println(2 + 3 * 4)

  println(1 == 2)

  println(!(1 == 2))

  // side effects
  private var aVar = 2
  aVar += 1029
  println(aVar)

  // Instructions (DO) vs Expressions (VALUE)
  private val aCondition = true

  private val aConditionValue = if(aCondition) 5 else 3
  println(aConditionValue)

  // Avoid mutation at the most deeper level
  var i = 0
  private val aWhile = while (i < 10) {
    println(i)
    i += 1
  }
  println(aWhile)

  // Everything in Scala is a definition!
  private val aWeirdValue = (aVar = 3)  // Unit === void
  println(aWeirdValue)

  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }

}
