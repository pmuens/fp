def say(callback: () => Unit): Unit = {
  callback()
}

def helloWorld(): Unit = { println("Hello World") }
def goodbyeWorld(): Unit = { println("Goodbye World") }

say(helloWorld)
say(goodbyeWorld)

def executeNTimes(f: () => Unit, n: Int): Unit = {
  for (_ <- 1 to n) f()
}

executeNTimes(helloWorld, 3)

// building our own `map` function
// simple `map` function
val mapNums = List(1, 2, 3)
val double = (i: Int) => i * 2
val triple = (i: Int) => i * 3

def map[A](f: (Int) => A, list: List[Int]): List[A] = {
  for {
    x <- list
  } yield f(x)
}

map(double, mapNums)

// generic `map` function
def map[A, B](f: A => B, list: Seq[A]): Seq[B] = {
  for {
    x <- list
  } yield f(x)
}

map(triple, mapNums)

// building our own `filter` function
import scala.collection.mutable

val filterNums = List(1, 2, 3, 4, 5, 6, 7, 8)
val isEven = (i: Int) => i % 2 == 0
val isOdd = (i: Int) => i % 2 != 0

def filter[A](f: A => Boolean, list: Seq[A]): Seq[A] = {
  val tmpList = new mutable.ListBuffer[A]()
  for {
    x <- list
  } yield if(f(x)) tmpList += x
  tmpList.toList
}

filter(isEven, filterNums)
filter(isOdd, filterNums)
