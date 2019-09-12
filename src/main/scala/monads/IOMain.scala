package monads

import monads.Utils._

object IOMain extends App {
  def loop: IO[Unit] = for {
    _ <- putStrLn("Type something (type (q) to quit)")
    input <- getLine
    _ <- putStrLn(s"You typed: $input")
    _ <- if (input == "q") IO(Unit) else loop
  } yield ()

  loop.run
}
