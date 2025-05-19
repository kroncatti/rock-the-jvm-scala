package lectures.part3FP

object ForComprehension extends App {
  // source = https://medium.com/wix-engineering/scala-comprehending-the-for-comprehension-67c9f7953655

  sealed abstract class Perhaps[+A] {
    def foreach(f: A => Unit): Unit
    def map[B](f: A => B): Perhaps[B]
    def flatMap[B](f: A => Perhaps[B]): Perhaps[B]
    def withFilter(f: A => Boolean): Perhaps[A]
  }
  case class YesItIs[A](value: A) extends Perhaps[A] {
    override def foreach(f: A => Unit): Unit = f(value)
    override def map[B](f: A => B): Perhaps[B] = YesItIs(f(value))
    override def flatMap[B](f: A => Perhaps[B]): Perhaps[B] = f(value)
    override def withFilter(f: A => Boolean): Perhaps[A] =
      if (f(value)) this else Nope
  }

  case object Nope extends Perhaps[Nothing] {
    override def foreach(f: Nothing => Unit): Unit = ()
    override def map[B](f: Nothing => B): Perhaps[B] = this
    override def flatMap[B](f: Nothing => Perhaps[B]): Perhaps[B] =
      this
    override def withFilter(f: Nothing => Boolean): Perhaps[Nothing] =
      this
  }

  val y3 = YesItIs(3)
  val y4 = YesItIs(4)
  val n = Nope

  // Both two elements below are equivalent (.foreach impl is necessary)
  for {
    a <- y3
  } println(a)
  y3.foreach(a => println(a))

  // Both two elements below are equivalent (.map impl is necessary)
  for {
    a <- y3
  } yield a * a
  y3.map(a => a * a)

  // Both two elements below are equivalent (.flatMap impl is necessary)
  for {
    a <- y3
    b <- y4
  } yield a * b
  y3.flatMap(a => y4.map(b => a * b))

  // Filtering by using if,  Both two elements below are equivalent (.withFilter is necessary)
  for {
    a <- y3
    if a > 1
    b <- y4
  } yield a * b
  y3.withFilter(a => a > 1).flatMap(a => y4.map(b => a * b))

  // more stuff
  for {
    a <- y3
    b <- y4
    c = a * b
  } yield c

}
