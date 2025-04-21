package lectures.part2OOP


object Exceptions extends App {

  // 1. Throwing exceptions
  val x: String = null
  // println(x.length) // NullPointerException

  // val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class

  // 2. How to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No integer for you my friend!")
    else 42

//  try {
//    getInt(true)
//  } catch {
//    case e: RuntimeException => println("Caught a runtime exception")
//    case e: Throwable => println("Other exception")
//  } finally {
//    println("Finally!!!")
//  }

  // 3. Creating your own exceptions

//  class MyException extends Exception
//  val myException = new MyException
//
//  throw myException

  // Pocket Calculator
  class PocketCalculator {
    private class OverflowException extends Exception
    private class UnderflowException extends Exception
    private class MathCalculationException extends RuntimeException("Dividing by zero")
    def add(x: BigInt, y: BigInt): BigInt = {
      if (x + y > Int.MaxValue) throw new OverflowException
      else x + y
    }

    def subtract(x: BigInt, y: BigInt): BigInt = {
      if (x - y < Int.MinValue) throw new UnderflowException
      else x - y
    }

    def multiply(x: Int, y: Int): Int = {
      x * y
    }

    def divide(x: Int, y: Int): Float = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }
  private val calculator: PocketCalculator = new PocketCalculator
  val a: BigInt = BigInt("2398312932189328382")
  val b: BigInt = BigInt("92389284984398298432984328942398")
  println(calculator.add(3, 5))
  println(calculator.add(a, b))

}
