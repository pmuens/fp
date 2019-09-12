// partially applied functions (multi-param-groups)
def add(a: Int)(b: Int): Unit = println(a + b)

def add2 = add(2)_
add2(3)
add2(4)

def add3 = add(3)_
add3(3)
add3(4)

// HTML wrapper
def wrap1(openTag: String)(content: String)(closeTag: String): Unit = {
  println(openTag + content + closeTag)
}
wrap1("<div>")("Hello World")("</div>")

def divWrapper1 = wrap1("<div>")(_: String)("</div>")
divWrapper1("Hello World")

def pWrapper1 = wrap1("<p>")(_: String)("</p>")
pWrapper1("Hello World")

// creating curried functions from single-param functions
def adder(a: Int, b: Int): Int = a + b
val addFunc = adder _

addFunc.isInstanceOf[Function2[_, _, _]]
val adderCurried = (adder _).curried
adderCurried(1)(2)

val adderCurried2 = adderCurried(2)
adderCurried2(3)

// partially applied functions (single-param-group)
def wrap2(openTag: String, content: String, closeTag: String): Unit = {
  println(openTag + content + closeTag)
}

def divWrapper2 = wrap2("<div>", _: String, "</div>")
divWrapper2("Hello World")
