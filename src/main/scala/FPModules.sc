import java.awt.Color

trait Animal

abstract class AnimalWithTail(tailColor: Color)

trait DogTailServices {
  // can only be mixed into classes that extend `AnimalWithTail`
  this: AnimalWithTail =>
    def wagTail(): Unit = println("Wagging tail")
    def lowerTail(): Unit = println("Lowering tail")
    def raiseTail(): Unit = println("Raising tail")
}

trait DogMouthServices {
  this: AnimalWithTail =>
    def bark(): Unit = println("Barking")
    def lick(): Unit = println("Licking")
}

object Podenco extends AnimalWithTail(Color.white) with DogTailServices with DogMouthServices

Podenco.bark()
Podenco.wagTail()
