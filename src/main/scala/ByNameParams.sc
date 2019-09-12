// a timer similar to the UNIX `time` function

// naive approach (doesn't work)
//def time[A, B](func: (A) => B): (Double, B) = {
//  val start = System.nanoTime()
//  val result = func() // what will be passed-in here?
//  val end = System.nanoTime()
//  val duration = end - start
//  (duration, result)
//}
//
//time(println("Test"))

def time[A](block: => A): (Double, A) = {
  val start = System.nanoTime()
  val result = block
  val end = System.nanoTime()
  val duration = end - start
  (duration, result)
}

time(println("Test"))
time {
  val a = 12
  val b = 13
  val result = a + b
  Thread.sleep(2000)
  println(result)
  result
}

// assertions
def byValueAssert(predicate: () => Boolean): Unit = {
  if (!predicate()) throw new AssertionError()
}
byValueAssert(() => 2 == 2)

def byNameAssert(predicate: => Boolean): Unit = {
  if (!predicate) throw new AssertionError()
}
byNameAssert(1 == 2)
