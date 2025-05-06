package lectures.part3FP

import scala.annotation.tailrec

object HOFsCurried extends App {
  // higher-order-function
  // map, flatMap, filter

  // HOF ==> applies a function N times over a given value

  // val nTimes(f, n, x)
  // val nTimes(f, 3, x) = f(f(f(x)))
  @tailrec
  private def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  private val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 5, 0))


  private def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))

  private val incrementTen = nTimesBetter(plusOne, 10)
  println(incrementTen(0))

  // curried functions
  val superUltraAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y

  // functions with multiple parameters list
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  private val standardFormatter: (Double => String) = curriedFormatter("%4.2f")
  private val preciseFormatter: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormatter(Math.PI))
  println(preciseFormatter(Math.PI))
}
