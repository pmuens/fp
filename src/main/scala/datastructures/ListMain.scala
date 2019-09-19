package datastructures

object ListMain extends App {
  val ex1: List[Double] = Nil
  val ex2: List[Int] = Cons(1, Nil)
  val ex3: List[Double] = Cons(1.0, Cons(2.0, Cons(3.0, Nil)))
  println("ex1")
  println(ex1)
  println()
  println("ex2")
  println(ex2)
  println()
  println("ex3")
  println(ex3)
  println()

  println("List.tail(ex3)")
  println(List.tail(ex3))
  println()

  println("List.setHead(ex3)")
  println(List.setHead(ex3, 0.0))
  println()

  println("List.drop(ex3, 2)")
  println(List.drop(ex3, 2))
  println()

  println("List.dropWhile(ex3, (num: Int) => num < 2.0)")
  println(List.dropWhile(ex3, (num: Double) => num < 2.0))
  println()

  println("List.append(ex3, Cons(4.0, Cons(5.0, Nil)))")
  println(List.append(ex3, Cons(4.0, Cons(5.0, Nil))))
  println()

  println("List.init(ex3)")
  println(List.init(ex3))
  println()

  println("List.foldRight(List(1, 2, 3), Nil: List[Int])(Cons(_ , _))")
  println(List.foldRight(List(1, 2, 3), Nil: List[Int])(Cons(_ , _)))
  println()

  println("List.sumFr(ex2)")
  println(List.sumFr(ex2))
  println()

  println("List.productFr(ex3)")
  println(List.productFr(ex3))
  println()

  println("List.lengthFr(ex3)")
  println(List.lengthFr(ex3))
  println()

  println("List.appendFr(ex3, Cons(4.0, Cons(5.0, Nil)))")
  println(List.appendFr(ex3, Cons(4.0, Cons(5.0, Nil))))
  println()

  println("List.concat(List(List(1, 2, 3, 4, 5, 6)))")
  println(List.concat(List(List(1, 2, 3, 4, 5, 6))))
  println()

  println("List.add1(List(1, 2, 3, 4))")
  println(List.add1(List(1, 2, 3, 4)))
  println()

  println("List.doubleToString(List(1.0, 2.0, 3.0, 4.0))")
  println(List.doubleToString(List(1.0, 2.0, 3.0, 4.0)))
  println()

  println("List.map(List(1, 2, 3, 4))(_ * 2)")
  println(List.map(List(1, 2, 3, 4))(_ * 2))
  println()

  println("List.filter(List(1, 2, 3, 4))(_ % 2 == 0)")
  println(List.filter(List(1, 2, 3, 4))(_ % 2 == 0))
  println()

  println("List.flatMap(List(1, 2, 3, 4))(i => List(i, i))")
  println(List.flatMap(List(1, 2, 3, 4))(i => List(i, i)))
  println()

  println("List.filterViaFlatMap(List(1, 2, 3, 4))(_ % 2 == 0)")
  println(List.filterViaFlatMap(List(1, 2, 3, 4))(_ % 2 == 0))
  println()

  println("List.addPairwise(List(1, 2, 3, 4), List(5, 6, 7, 9))")
  println(List.addPairwise(List(1, 2, 3, 4), List(5, 6, 7, 9)))
  println()

  println("List.zipWith(List(1, 2, 3, 4), List(5, 6, 7, 9))(_ + _)")
  println(List.zipWith(List(1, 2, 3, 4), List(5, 6, 7, 9))(_ + _))
  println()

  println("List.sumFl(List(1, 2, 3, 4))")
  println(List.sumFl(List(1, 2, 3, 4)))
  println()

  println("List.productFl(List(1, 2, 3, 4))")
  println(List.productFl(List(1, 2, 3, 4)))
  println()

  println("List.lengthFl(List(1, 2, 3, 4))")
  println(List.lengthFl(List(1, 2, 3, 4)))
  println()

  println("List.reverse(List(1, 2, 3, 4))")
  println(List.reverse(List(1, 2, 3, 4)))
  println()
}
