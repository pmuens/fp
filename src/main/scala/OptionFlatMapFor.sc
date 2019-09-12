def makeInt(num: String): Option[Int] = {
  try {
    Some(num.trim.toInt)
  } catch {
    case e: Exception => None
  }
}

val x = makeInt("1")
val y = makeInt("2")

// adding via `getOrElse`
x.getOrElse(0) + y.getOrElse(0)

// adding via `flatMap`
x flatMap {
  a => y map {
    b => a + b
  }
}

// since `Option` supports `map` and `flatMap` it can be used in `for` expressions
for {
  a <- makeInt("1")
  b <- makeInt("2")
  c <- makeInt("3")
} yield a + b + c

// `for` expressions are better than `getOrElse`

val resFor = for {
  a <- makeInt("1")
  b <- makeInt("two")
  c <- makeInt("3")
} yield a + b + c

val resGetOrElse = makeInt("1").getOrElse(0) +
  makeInt("two").getOrElse(0) +
  makeInt("3").getOrElse(0)

println(resFor)
println(resGetOrElse)
