package lectures.part2OOP

object AnonymousClasses extends App {
  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("So Funny, hahahahah!")
  }

  println(funnyAnimal.getClass) // lectures.part2OOP.AnonymousClasses$$anon$1

  // behind the scenes
  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("So Funny, hahahahah!")
  }

  val newFunnyAnimal = new AnonymousClasses$$anon$1
  print(newFunnyAnimal)

  // You still need to pass the constructor parameters to the downstream
}
