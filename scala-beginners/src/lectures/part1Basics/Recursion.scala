package lectures.part1Basics

import scala.annotation.tailrec

object Recursion extends App {
  // Our previous factorial would not work for big numbers, stack over flow
  def anotherFactorial(n: Int): BigInt = {

    @tailrec
    def factHelper(x: Int, acc: BigInt): BigInt = {
      if (x == 0 || x == 1) acc
      else factHelper(x - 1, x * acc)
    }
    factHelper(n, 1)
  }

  // The current stack-trace is replaced by the new invocation, this is tail recursion, this is why we can use it
  // tailrec will replace loops

  val res = anotherFactorial(10)

  @tailrec
  def stringConcat(str: String, n: Int, acc: String): String = {
    if (n <= 0) acc
    else stringConcat(str, n - 1, str + acc)
  }

  val resStrConcat = stringConcat("myString ", 5, "")
  println(resStrConcat)

  // Fibonacci
  private def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciTailRec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fibonacciTailRec(i + 1, last + nextToLast, last)
    }

    if (n <= 2) 1
    else fibonacciTailRec(2, 1, 1)
  }

  val resFib = fibonacci(10)
  println(resFib)
}

