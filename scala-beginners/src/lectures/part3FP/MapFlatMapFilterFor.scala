package lectures.part3FP

object MapFlatMapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map((value: Int) => value + 1))

  // filter
  println(list.map(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  // print all combinations between two lists
  val listOne = List(1, 2, 3, 4)
  val listTwo = List('a', 'b', 'c', 'd')
  val combinations = listOne.flatMap(num => listTwo.map(char => s"${char}${num}"))
  println(combinations)

  // foreach
  list.foreach(println)

  // for-comprehensions
  // things start getting too big!!!
  val colors = List("black", "white")

  val forCombinations = for {
    n <- listOne
    c <- listTwo
    color <- colors
  } yield "" + c + n + "-" + color
  println(forCombinations)

  for {
    n <- listOne
  } println

  // syntax overlap

  list.map {
    x => x * 2
  }

  // creating a maybe
  abstract class Maybe [+T] {
    def map[B](f: T => B): Maybe[B]
    def flatMap[B](f: T => Maybe[B]): Maybe[B]
    def filter(p: T => Boolean): Maybe[T]
  }

  case object MaybeNot extends Maybe[Nothing] {
    def map[B](f: Nothing => B): Maybe[B] = MaybeNot
    def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot
    def filter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot
  }

  case class Just [+T](value: T) extends Maybe[T] {
    def map[B](f: T => B): Maybe[B] = Just(f(value))
    def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(value)
    def filter(p: T => Boolean): Maybe[T] = if (p(value)) this else MaybeNot
  }

  // testing it

  val just3 = Just(3)
  println(just3)
  println(just3.map(_ * 2))
  println(just3.flatMap(x => Just(x % 2 == 0)))
  println(just3.filter(_ % 2 == 0 ))
}
