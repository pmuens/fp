def f(a: Int): (Int, String) = {
  val res = a * 2
  val msg = s"f result: $res. "
  (res, msg)
}

def g(a: Int): (Int, String) = {
  val res = a * 3
  val msg = s"g result: $res. "
  (res, msg)
}

def h(a: Int): (Int, String) = {
  val res = a * 4
  val msg = s"h result: $res. "
  (res, msg)
}

// naive way of binding `f` and `g`
val (resF, msgF) = f(10)
val (resG, msgG) = g(resF)
println(s"Chained result: $resG")
println(s"Chained message: $msgF $msgG")

// writing a `bind` function
def bind(f: Int => (Int, String), tup: (Int, String)): (Int, String) = {
  val (intRes, strRes) = f(tup._1)
  (intRes, tup._2 + strRes)
}

val fResult = f(10)
val gResult = bind(g, fResult)
val hResult = bind(h, gResult)
println(hResult)
