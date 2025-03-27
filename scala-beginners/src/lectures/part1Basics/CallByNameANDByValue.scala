package lectures.part1Basics

object CallByNameANDByValue extends App {

  // We evaluate x only once, when the function is invoked
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value:  " + x)
  }

  // We only when it is called, it is evaluated everytime it is called!!!
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }


  calledByValue(System.nanoTime())
  println("sep")
  calledByName(System.nanoTime())

  // A deeper example
  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  // printFirst(infinite(), 34) --> stackoverflow (callByValue, it evaluates infinite())
  printFirst(34, infinite()) // this works, callByValue!!! infinite() is never evaluated
}
