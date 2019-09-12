package monads

class IO[A] private (block: => A) {
  def map[B](f: A => B): IO[B] = flatMap(a => IO(f(a)))

  def flatMap[B](customAlg: A => IO[B]): IO[B] = {
    val res1: IO[B] = customAlg(run)
    val res2: B = res1.run
    IO(res2)
  }

  def run: A = block
}

object IO {
  def apply[A](a: => A): IO[A] = new IO(a)
}
