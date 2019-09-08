// "hello world" example
def greet(name: String): Unit = println(s"Hello $name!")
greet("John Doe")

// update-as-you-copy example
case class Person(firstName: String, lastName: String)

val janeDoe = Person("Jane", "Doe")
println(janeDoe)

val janeSchmidt = janeDoe.copy(lastName = "Schmidt")
println(janeDoe)
println(janeSchmidt)

// functions as variables
val isEven = (i: Int) => i % 2 == 0
val double = (i: Int) => i * 2
val triple = (i: Int) => i * 3
val sum = (a: Int, b: Int) => a + b

// passing functions into other functions
val ints = List(1, 2, 3, 4, 5)
ints.filter(isEven)
ints.map(double)

// storing functions in a Map
val functions = Map(
  "x2" -> double,
  "x3" -> triple
)

// manual Eta Expansion
// (manually convert a method to a function)
def triple(i: Int) = i * 3
val tripleFn = triple _
tripleFn
tripleFn(1)
