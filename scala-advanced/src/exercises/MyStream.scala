package exercises

abstract class MyStream[+A] {
  def isEmpty: Boolean
  def head: A
  def tail: MyStream[A]

  def #::[B >: A](element: B): MyStream[B]                // prepends element
  def ++[B >: A](anotherStream: MyStream[B]): MyStream[B] // concatenate to streams

  def foreach(f: A => Unit): Unit
  def map[B](f: A => B): MyStream[B]
  def flatMap[B](f: A => MyStream[B]): MyStream[B]
  def filter(predicate: A => Boolean): MyStream[A]

  def take(n: Int): MyStream[A] // takes first N elements out of the stream
  def takeAsList(n: Int): List[A]
}

object MyStream {
  def from[A](start: A)(generator: A => A): MyStream[A] = ???
}
