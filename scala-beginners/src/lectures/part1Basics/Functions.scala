package lectures.part1Basics

import scala.annotation.tailrec

object Functions extends App {
  def aFunction(a: String, b: Int): String = {
    a + " " +  b
  }

  println(aFunction("hey", 2))

  // Very commonly used recursion, avoid loops
  def aRepeatedFn(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFn(aString, n - 1)
  }

  println(aRepeatedFn("hey", 4))

  // Factorial
  private def factorial(n: Int): Int = {
    if (n == 1 || n == 0) 1
    else n * factorial(n - 1)
  }
  val res = factorial(5)
  println(res)

  // Fibonacci
  private def fibonacci(n: Int): Int = {
    if (n == 0 || n == 1) n
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  val resFib = fibonacci(8)
  println(resFib)

  // isPrime
  private def isPrime(n: Int): Boolean = {
    val max = n

    @tailrec
    def isPrimeAcc(max: Int, n: Int): Boolean  = {
      if (n == 1) true
      else  (if (max % n == 0 && max != n) false else isPrimeAcc(max, n - 1))
    }
    isPrimeAcc(max, n)
  }
  val resIsPrime = isPrime(23196)
  println(resIsPrime)

}
