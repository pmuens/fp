package monads

object Utils {
  def putStrLn(msg: String): IO[Unit] = {
    println(msg)
    IO(Unit)
  }

  def getLine: IO[String] = {
    val input = scala.io.StdIn.readLine()
    IO(input)
  }
}
