package typeclasses

// 1. define behavior in a trait that takes a generic type
trait BehavesLikeHuman[A] {
  def speak(a: A): Unit
  def eatHumanFood(a: A): Unit
}

// 2. create instances of the types we want to extend
object BehavesLikeHumanInstances {
  implicit val dogBehavesLikeHuman: BehavesLikeHuman[Dog] = new BehavesLikeHuman[Dog] {
    def speak(dog: Dog): Unit = {
      println(s"I'm a dog. My name is ${dog.name}")
    }
    def eatHumanFood(dog: Dog): Unit = {
      println(s"I'm a dog. I ate human food")
    }
  }
}

// 3a. add functions that can be used on a dog instance --> `speak(dog)`
object BehavesLikeHuman {
  def speak[A](a: A)(implicit behavesLikeHumanInstance: BehavesLikeHuman[A]): Unit = {
    behavesLikeHumanInstance.speak(a)
  }
  def eatHumanFood[A](a: A)(implicit behavesLikeHumanInstance: BehavesLikeHuman[A]): Unit = {
    behavesLikeHumanInstance.eatHumanFood(a)
  }
}

// 3b. add methods to dog class --> `dog.speak`
object BehavesLikeHumanSyntax {
  implicit class BehavesLikeHumanOps[A](value: A) {
    def speak(implicit behavesLikeHumanInstance: BehavesLikeHuman[A]): Unit = {
      behavesLikeHumanInstance.speak(value)
    }
    def eatHumanFood(implicit behavesLikeHumanInstance: BehavesLikeHuman[A]): Unit = {
      behavesLikeHumanInstance.eatHumanFood(value)
    }
  }
}
