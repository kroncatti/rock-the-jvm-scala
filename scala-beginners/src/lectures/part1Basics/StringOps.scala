package lectures.part1Basics

object StringOps extends App {
  val str: String = "Hello, I am learning Scala"


  println(str.charAt(2))
  println(str.substring(2, 7))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "/"))

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')

  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is ${name} and I am ${age} years old."
  println(greeting)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.3f burgers per minute"
  println(myth)

  // raw-interpolator
  println(raw"This is a \n newline") // no newline
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
