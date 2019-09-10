case class Person(firstName: String, lastName: String)
val people = List(
  Person(firstName = "John", lastName = "Doe"),
  Person(firstName = "Jane", lastName = "Doe")
)

val transformed = for {
  person <- people          // generator
  fName = person.firstName  // definition
  if fName startsWith "Jo"  // filter
} yield fName.toUpperCase

// creating our own custom data type to be used with `for` expressions
import scala.collection.mutable.ArrayBuffer
case class Sequence[A](private val initialElements: A*) {
  private val elems = ArrayBuffer[A]()

  elems ++= initialElements

  def foreach(block: A => Unit): Unit = {
    elems.foreach(block)
  }

  def map[B](p: A => B): Sequence[B] = {
    val tmp = elems.map(p)
    Sequence(tmp: _*)
  }

  def withFilter(p: A => Boolean): Sequence[A] = {
    val tmp = elems.filter(p) // calling the normal `filter` here
    Sequence(tmp: _*)
  }

  private def flattenLike[B](seqOfSeq: Sequence[Sequence[B]]): Sequence[B] = {
    var xs = ArrayBuffer[B]()
    for (listB: Sequence[B] <- seqOfSeq) {
      for (elem <- listB) {
        xs += elem
      }
    }
    Sequence(xs: _*)
  }

  def flatMap[B](p: A => Sequence[B]): Sequence[B] = {
    val tmp: Sequence[Sequence[B]] = map(p)
    flattenLike(tmp)
  }
}

val test = Sequence(1, 2, 3, 4, 5, 6)

// 1) `for` loop
for (elem <- test) println(elem)

// 2) `for` expression with `yield`
val double = for {
  elem <- test
} yield elem * 2

// 3) `for` expression with `if`
val even = for {
  elem <- test
  if elem % 2 == 0
} yield elem

// 4) `for` expression with multiple generators
case class Friend(name: String)
val myFriends = Sequence(
  Friend("Micheal"),
  Friend("David"),
  Friend("Tucker")
)
val herFriends = Sequence(
  Friend("Joe"),
  Friend("Tucker"),
  Friend("David"),
  Friend("Lisa")
)
val mutualFriends = for {
  myFriend <- myFriends
  herFriend <- herFriends
  if myFriend == herFriend
} yield myFriend
