package exercises

import java.{util => ju}

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

object EmptyStream extends MyStream[Nothing] {
  def isEmpty: Boolean        = true
  def head: Nothing           = throw new NoSuchElementException
  def tail: MyStream[Nothing] = throw new NoSuchElementException

  def #::[B >: Nothing](element: B): MyStream[B]                = new Cons(element, this)
  def ++[B >: Nothing](anotherStream: MyStream[B]): MyStream[B] = anotherStream

  def foreach(f: Nothing => Unit): Unit = ()

  def map[B](f: Nothing => B): MyStream[B]                     = this
  def flatMap[B](f: Nothing => MyStream[B]): MyStream[B]       = this
  def filter(predicate: Nothing => Boolean): MyStream[Nothing] = this

  def take(n: Int): MyStream[Nothing]   = this
  def takeAsList(n: Int): List[Nothing] = Nil
}

class Cons[+A](head: A, tail: => MyStream[A]) extends MyStream[A] {
  def isEmpty: Boolean  = ???
  def head: A           = ???
  def tail: MyStream[A] = ???

  def #::[B >: A](element: B): MyStream[B]                = ???
  def ++[B >: A](anotherStream: MyStream[B]): MyStream[B] = ???

  def foreach(f: A => Unit): Unit                  = ???
  def map[B](f: A => B): MyStream[B]               = ???
  def flatMap[B](f: A => MyStream[B]): MyStream[B] = ???
  def filter(predicate: A => Boolean): MyStream[A] = ???

  def take(n: Int): MyStream[A]   = ???
  def takeAsList(n: Int): List[A] = ???
}

object MyStream {
  def from[A](start: A)(generator: A => A): MyStream[A] = ???
}
