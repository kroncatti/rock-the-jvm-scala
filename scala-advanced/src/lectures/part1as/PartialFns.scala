package lectures.part1as

object PartialFns extends App {
  val aFunction = (x: Int) => x + 1
  val aFussyFunction = (x: Int) =>
    if (x == 1) 42
    else if (x == 2) 56
    else if (x == 5) 999
    else throw new FunctionNotApplicableException

  private class FunctionNotApplicableException extends RuntimeException

  val aNicerFussyFunction = (x: Int) => x match {
    case 1 => 42
    case 2 => 56
    case 5 => 99
  }
  //  Domain {1, 2, 5} => Int => Partial Function from Int to Int

  private val aPartialFunction: PartialFunction[Int, Int] = {
    case 1 => 42
    case 2 => 56
    case 5 => 99
  }

  println(aPartialFunction(2))
  println(aPartialFunction.isDefinedAt(328))

  // Lifting is also possible
  private val lifted = aPartialFunction.lift
  println(lifted(2)) // Wrapped in option
  println(lifted(329))

  // extended
  private val pfChain = aPartialFunction.orElse[Int, Int]{
    case 45 => 67
  }

  println(pfChain(45))

  // Partial Functions extend normal functions, they are a subtype of normal functions
  val aTotalFunction: Int => Int = {
    case 1 => 99
  }

  // HOFs accept PartialFunctions as well
  private val aMappedList = List(1, 2, 3, 4).map {
    case 1 => 42
    case 2 => 78
    case 3 => 120000
    case 4 => 120
  }
  println(aMappedList)
  // Partial functions can have only ONE PARAMETER TYPE, otherwise match case would not be possible

}
