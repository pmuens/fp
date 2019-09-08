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
