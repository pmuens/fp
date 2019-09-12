// defining our own `while` control structure
def whilst(cond: => Boolean)(block: => Unit): Unit = {
  while(cond) {
    block
  }
}

var i = 0
whilst(i < 5) {
  i = i + 1
  println(i)
}

// custom ifBothTrue function
def ifBothTrue(cond1: => Boolean)(cond2: => Boolean)(block: => Unit): Unit = {
  if (cond1 && cond2) block
}

ifBothTrue(1 == 1)(2 ==2) {
  println("both are true!")
}

// `implicit` keyword
def canGetDiscount(age: Int)(implicit isPremium: Boolean): Boolean = {
  val discountApplies = age > 18 && isPremium
  if (discountApplies){
    println("Discount applied")
  } else {
    println("Discount NOT applied")
  }
  discountApplies
}

// this value will be automatically supplied as the `isPremium` param
implicit val hasBoughtALot: Boolean = true
canGetDiscount(20)

// default values
def func1(a: Int = 1)(b: Int = 2)(c: Int = 3): Int = {
  val result = a + b + c
  println(result)
  result
}

func1()()()

def func2(a: Int)(b: Int = 2)(c: Int = b): Int = {
  val result = a + b + c
  println(result)
  result
}

func2(1)()()
