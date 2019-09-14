package monads

import monads.Utils.{getLine, putStr, toInt}

object StateTMain extends App {
  case class SumState(sum: Int)

  implicit val IOMonad: Monad[IO] = new Monad[IO] {
    def lift[A](a: => A): IO[A] = {
      IO(a)
    }

    def flatMap[A, B](ma: IO[A])(f: A => IO[B]): IO[B] = ma.flatMap(f)
  }

  def doSumWithStateT(newValue: Int): StateT[IO, SumState, Int] = StateT { oldState: SumState =>
    val newSum = newValue + oldState.sum
    val newState: SumState = oldState.copy(sum = newSum)
    IO(newState, newSum)
  }

  def liftIoIntoStateT[A](io: IO[A]): StateT[IO, SumState, A] = StateT { s =>
    io.map(a => (s, a))
  }

  def getLineAsStateT: StateT[IO, SumState, String] = liftIoIntoStateT(getLine)
  def putStrAsStateT(s: String): StateT[IO, SumState, Unit] = liftIoIntoStateT(putStr(s))

  def loop: StateT[IO, SumState, Unit] = for {
    _ <- putStrAsStateT("Enter an integer, or (q)uit: ")
    input <- getLineAsStateT
    _ <- if (input == "q") {
      liftIoIntoStateT(IO(Unit))
    } else for {
      i <- liftIoIntoStateT(IO(toInt(input)))
      _ <- doSumWithStateT(i)
      _ <- loop
    } yield Unit
  } yield Unit

  val result = loop.run(SumState(0)).run
  println(s"SumState: $result")
}
