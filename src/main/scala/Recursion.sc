// defining some lists
val listEmpty1: List[Int] = List()
val listEmpty2: List[Int] = Nil
listEmpty1 == listEmpty2

val list1 = List(1, 2, 3)
val list2 = 1 :: 2 :: 3 :: Nil // using "cons cells"
list1 == list2

// recursive sum function
def sum(xs: List[Int]): Int = {
  xs match {
    case Nil => 0
    case h :: t => h + sum(t) // h = head, t = tail
  }
}
sum(List(1, 2, 3, 4, 5))

def sumWithLogging(xs: List[Int]): Int = {
  xs match {
    case Nil =>
      println("case1: Nil was matched")
      0
    case h :: t =>
      println(s"case2: head = $h, tail = $t")
      h + sumWithLogging(t)
  }
}
sumWithLogging(List(1, 2, 3, 4, 5))

def sumWithStackTrace(xs: List[Int]): Int = {
  xs match {
    case Nil =>
      val stackTraceAsArray = Thread.currentThread.getStackTrace
      stackTraceAsArray.foreach(println)
      0
    case x :: xs =>
      x + sumWithStackTrace(xs)
  }
}
sumWithStackTrace(List.range(1, 5))

// tail-recursion
import scala.annotation.tailrec

// tail-recursive sum function
def sumTailRec(list: List[Int]): Int = {
  @tailrec
  def sumWithAccum(xs: List[Int], accum: Int): Int = {
    xs match {
      case Nil => accum
      case x :: xs => sumWithAccum(xs, accum + x)
    }
  }
  sumWithAccum(list, 0)
}
sumTailRec(List.range(1, 5))

// tail-recursive multiply function
def multiTailRec(list: List[Int]): Int = {
  @tailrec
  def multiWithAccum(xs: List[Int], accum: Int): Int = {
    xs match {
      case Nil => accum
      case x :: xs => multiWithAccum(xs, accum * x)
    }
  }
  multiWithAccum(list, 1)
}
multiTailRec(List.range(1, 5))
