package datastructures

import scala.annotation.tailrec

sealed trait List[+A]

// data constructors
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

// companion object
object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(xs: List[Double]): Double = xs match {
    case Nil => 1.0
    case Cons(x, xs) => x * product(xs)
  }

  def tail[A](xs: List[A]): List[A] = xs match {
    case Nil => sys.error("tail of empty list")
    case Cons(_, xs) => xs
  }

  def setHead[A](xs: List[A], x: A): List[A] =
    Cons(x, tail(xs))

  @tailrec
  def drop[A](xs: List[A], n: Int): List[A] = {
    if (n <= 0) xs
    else xs match {
      case Nil => Nil
      case Cons(_, xs) => drop(xs, n - 1)
    }
  }

  @tailrec
  def dropWhile[A](xs: List[A], f: A => Boolean): List[A] = xs match {
    case Cons(x, xs) if f(x) => dropWhile(xs, f)
    case _ => xs
  }

  def append[A](xs1: List[A], xs2: List[A]): List[A] = xs1 match {
    case Nil => xs2
    case Cons(x, xs) => Cons(x, append(xs, xs2))
  }

  def init[A](xs: List[A]): List[A] = xs match {
    case Nil => sys.error("init of empty list")
    case Cons(_, Nil) => Nil
    case Cons(x, xs) => Cons(x, init(xs))
  }

  def foldRight[A, B](xs: List[A], z: B)(f: (A, B) => B): B = xs match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }

  def sumFr(xs: List[Int]): Int =
    foldRight(xs, 0)((x, y) => x + y)

  def productFr(xs: List[Double]): Double =
    foldRight(xs, 1.0)(_ * _)

  def lengthFr[A](xs: List[A]): Int =
    foldRight(xs, 0)((_, accum) => accum + 1)

  def appendFr[A](xs1: List[A], xs2: List[A]): List[A] =
    foldRight(xs1, xs2)(Cons(_,_))

  def concat[A](xs: List[List[A]]): List[A] =
    foldRight(xs, Nil: List[A])(append)

  def add1(xs: List[Int]): List[Int] =
    foldRight(xs, Nil: List[Int])((x, xs) => Cons(x + 1, xs))

  def doubleToString(xs: List[Double]): List[String] =
    foldRight(xs, Nil: List[String])((x, xs) => Cons(x.toString, xs))

  def map[A, B](xs: List[A])(f: A => B): List[B] =
    foldRight(xs, Nil: List[B])((x, xs) => Cons(f(x), xs))

  def filter[A](xs: List[A])(f: A => Boolean): List[A] =
    foldRight(xs, Nil: List[A])((x, xs) => if (f(x)) Cons(x, xs) else xs)

  def flatMap[A, B](xs: List[A])(f: A => List[B]): List[B] =
    concat(map(xs)(f))

  def filterViaFlatMap[A](xs: List[A])(f: A => Boolean): List[A] =
    flatMap(xs)(a => if (f(a)) List(a) else Nil)

  def addPairwise(xs1: List[Int], xs2: List[Int]): List[Int] = (xs1, xs2) match {
    case (_, Nil) => Nil
    case (Nil, _) => Nil
    case (Cons(x1, xs1), Cons(x2, xs2)) => Cons(x1 + x2, addPairwise(xs1, xs2))
  }

  def zipWith[A, B, C](xs1: List[A], xs2: List[B])(f: (A, B) => C): List[C] = (xs1, xs2) match {
    case (_, Nil) => Nil
    case (Nil, _) => Nil
    case (Cons(x1, xs1), Cons(x2, xs2)) => Cons(f(x1, x2), zipWith(xs1, xs2)(f))
  }

  @tailrec
  def foldLeft[A, B](xs: List[A], z: B)(f: (B, A) => B): B = xs match {
    case Nil => z
    case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
  }

  def sumFl(xs: List[Int]): Int =
    foldLeft(xs, 0)((x, y) => x + y)

  def productFl(xs: List[Double]): Double =
    foldLeft(xs, 1.0)(_ * _)

  def lengthFl[A](xs: List[A]): Int =
    foldLeft(xs, 0)((accum, _) => accum + 1)

  def reverse[A](xs: List[A]): List[A] =
    foldLeft(xs, List[A]())((accum, x) => Cons(x, accum))

  // convenience method so that we can do stuff like `List(1, 2, 3, 4)`
  def apply[A](xs: A*): List[A] =
    if (xs.isEmpty) Nil else Cons(xs.head, apply(xs.tail: _*))
}
