package laziness

object StreamMain extends App {
  // finite streams
  val res1 = Stream(1, 2, 3).take(2).toList
  println(res1)

  val res2 = Stream(1, 2, 3, 4).map(_ + 10).filter(_ % 2 == 0).toList
  println(res2)

  // infinite stream
  val ones: Stream[Int] =  Stream.cons(1, ones)

  val res3 = ones.take(5).toList
  println(res3)

  val res4 = ones.map(_ + 1).exists(_ % 2 == 0)
  println(res4)

  val res5 = Stream.fibs.take(10).toList
  println(res5)
}
