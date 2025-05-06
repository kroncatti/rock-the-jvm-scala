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
  println(
    listOne.flatMap(
      num => listTwo.map(
      char => s"${char}${num}"
    )
  )
  )
}
