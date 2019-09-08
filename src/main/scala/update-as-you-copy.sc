// update-as-you-copy example
case class Person(firstName: String, lastName: String)

val janeDoe = Person("Jane", "Doe")
println(janeDoe)

val janeSchmidt = janeDoe.copy(lastName = "Schmidt")
println(janeDoe)
println(janeSchmidt)
