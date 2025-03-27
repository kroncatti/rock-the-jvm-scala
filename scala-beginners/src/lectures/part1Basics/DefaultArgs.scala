package lectures.part1Basics

object DefaultArgs extends App {


  def trFact(n: Int, acc: Int = 1): Int = {
    if (n == 1 || n == 0) acc
    else trFact(n - 1, n * acc)
  }

  val res = trFact(10)
  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("Saving picture...")
  savePicture("bmp") // it works!!
  // savePicture(10) // it doesn't work, compiler gets lost since we have multiple ints
  savePicture(width = 200) // it works!! named params
}
