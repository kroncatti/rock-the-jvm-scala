package book.chapter2

import scala.annotation.tailrec

object MyModule {
  private def abs(n: Int): Int = if (n < 0) -n else n

  private def factorial(n: Int): Int = {
    @tailrec
    def loop(n: Int, acc: Int): Int =
      if (n == 0) acc else loop(n - 1, acc * n)

    loop(n, 1)
  }

  private def formatter(x: Int, fn: (Int) => Int) = {
    s"The result of the operation for: $x is equal to: ${fn(x)}"
  }

  private def fibonacci(n: Int): Int = {
    // 0, 1, 1, 2, 3, 5, 8, 13
    @tailrec
    def loop(n: Int, previous: Int, current: Int): Int = {
      if (n <= 0) previous else loop(n - 1, current, current + previous)
    }
    loop(n, 0, 1)
  }

  def main(args: Array[String]): Unit = {
    println(formatter(3, abs))
    println(formatter(10, factorial))
    println(fibonacci(0))
  }
}

