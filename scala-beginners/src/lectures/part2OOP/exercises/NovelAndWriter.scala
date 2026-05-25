package lectures.part2OOP.exercises

import java.io.Writer

class Writer(firstName: String, surname: String, val yearOfBirth: Int) {
  def fullname(): String = firstName + " " + surname;
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {

  def authorAge(): Int = yearOfRelease - author.yearOfBirth

  def isWrittenBy(author: Writer): Boolean = this.author == author

  def copy(newYearRelease: Int) = new Novel(name, newYearRelease, author)
}

object Checking extends App {
  val writer = new Writer(firstName = "Kaleb", surname = "Roncatti", yearOfBirth = 1998)
  val novel = new Novel(name = "Star wards", yearOfRelease = 2000, author = writer)

  println(novel.copy(2003))
}