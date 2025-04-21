import scala.math._


val list: List[Int] = List(1, 2, 3, 4)

def myTestFn(i: Int, j: Int) = i + j

def testingToLowerCase(s: String) = s.toLowerCase()

println(list.reduceLeft(myTestFn))

def testingFoldMechanism(name: Option[String] = None) =
  name.fold[String]("default_value")(testingToLowerCase)

def testingGetOrElseMechanism(name: Option[String] = None) =
  name.getOrElse("DEFAULT_VALUE").toLowerCase()

testingFoldMechanism(Some("TESTING"))


// Playing around with traits and case classes
sealed trait Shape {
  def perimeter(): Double
}

// More object-oriented
case class Circle(radius: Int) extends Shape {
  def perimeter() = 2 * Pi * radius
}
case class Rectangle(x: Int, y: Int) extends Shape {
  def perimeter() = 2 * x + 2 * y
}

Circle(2).perimeter()
Rectangle(2, 4).perimeter()

// more functional alike style
def perimeter(shape: Shape): Double =
  shape match {
    case Circle(radius) => 2 * Pi * radius
    case Rectangle(x, y) => 2 * x + 2 * y
  }

perimeter(Circle(2))
perimeter(Rectangle(2, 4))

val names = Seq("my-NAME", "my-OTHER-name")

names.flatMap(_.toLowerCase)