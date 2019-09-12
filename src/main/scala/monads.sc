// a Monad has a `map`, `flatMap` and `apply` method
class Wrapper[A] private (value: A) {
  def map[B](f: A => B): Wrapper[B] = {
    val newValue = f(value)
    new Wrapper(newValue)
  }

  def flatMap[B](f: A => Wrapper[B]): Wrapper[B] = {
    f(value)
  }

  override def toString = value.toString
}
object Wrapper {
  def apply[A](value: A): Wrapper[A] = new Wrapper(value)
}

val resInt = for {
  a <- Wrapper(1)
  b <- Wrapper(2)
  c <- Wrapper(3)
} yield a + b + c
println(resInt)

val resString = for {
  a <- Wrapper("a")
  b <- Wrapper("b")
  c <- Wrapper("c")
} yield a + b + c
println(resString)

// a `Debuggable` wrapper to use function-binding in `for` expressions
case class Debuggable[A](value: A, log: List[String]) {
  def map[B](f: A => B): Debuggable[B] = {
    val res = f(this.value)
    Debuggable(res, this.log)
  }

  def flatMap[B](f: A => Debuggable[B]): Debuggable[B] = {
    val res = f(this.value)
    Debuggable(res.value, this.log ::: res.log)
  }
}

def f(a: Int): Debuggable[Int] = {
  val result = a * 2
  Debuggable(result, List(s"f: a ($a) * 2 = $result"))
}

def g(a: Int): Debuggable[Int] = {
  val result = a * 3
  Debuggable(result, List(s"g: a ($a) * 3 = $result"))
}

def h(a: Int): Debuggable[Int] = {
  val result = a * 4
  Debuggable(result, List(s"h: a ($a) * 4 = $result"))
}

val finalResult = for {
  fRes <- f(100)
  gRes <- g(fRes)
  hRes <- h(gRes)
} yield hRes
println(s"value: ${finalResult.value}")
println(s"message:\n")
finalResult.log.foreach(l => println(l))
