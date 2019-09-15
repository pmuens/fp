package scalacheck

object ListUtils {
  def dropAllButFirst[A](list: List[A], dropee: A): List[A] = {
    dropAllButFirst(list, dropee, 0)
  }

  private def dropAllButFirst[A](list: List[A], dropee: A, foundCount: Int): List[A] = list match {
    case Nil => Nil
    case x :: xs if x == dropee =>
      if (foundCount == 0) {
        x :: dropAllButFirst(xs, dropee, foundCount + 1)
      } else {
        dropAllButFirst(xs, dropee, foundCount + 1)
      }
    case x :: xs =>
      x :: dropAllButFirst(xs, dropee, foundCount)
  }
}
