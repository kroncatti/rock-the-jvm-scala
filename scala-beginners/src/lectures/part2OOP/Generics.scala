package lectures.part2OOP

object Generics extends App {
  // RESUMING VARIANCE PROBLEM //
  // if B extends A, should List[B] extend List[A] ???
  // YES! (covariant) (List[+A])
  // NO! (invariant) (default, List[A])
  // HELL NO! (contravariant) (List[-A])
  class MyList[+A] {
    // use type A
    def add[B >: A] (element: B): MyList[B] = ???
    /*
       A = Cat
       B = Dog = Animal
       If I add B, the list becomes a list of Animal's
     */
  }

  // Very generic and very close to Typescript
  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  private object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. Covariance class;
  // List[Cat] extends List[Animal] ==> COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ????????? HARD QUESTION --> We return a list of animals, go to add function as an example

  // 2. Invariance class;
  class InvariantList[A]
  // val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] // not allowed

  // 3. Contravariant class;
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types (only subtypes of animal)
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  // class Car
  // val newCage = new Cage(new Car) // Compile error

  class OtherCage[A >: Animal](animal: A)
  // val cage = new Cage(new Dog) // does not work, Dog is a subtype of Animal
}
