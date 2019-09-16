package typeclasses

sealed trait Animal
final case class Dog(name: String) extends Animal
final case class Cat(name: String) extends Animal
final case class Bird(name: String) extends Animal

object Main extends App {
  val ruben = Dog("Ruben")

  import BehavesLikeHumanInstances.dogBehavesLikeHuman
  BehavesLikeHuman.speak(ruben)(dogBehavesLikeHuman)
  BehavesLikeHuman.eatHumanFood(ruben)(dogBehavesLikeHuman)

  import BehavesLikeHumanSyntax.BehavesLikeHumanOps
  ruben.speak
  ruben.eatHumanFood
}
