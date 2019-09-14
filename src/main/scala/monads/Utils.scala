package monads

object Utils {
  def putStrLn(msg: String): IO[Unit] = {
    println(msg)
    IO(Unit)
  }

  def putStr(msg: String): IO[Unit] = {
    print(msg)
    IO(Unit)
  }

  def getLine: IO[String] = {
    val input = scala.io.StdIn.readLine()
    IO(input)
  }

  def toInt(s: String): Int = {
    try {
      s.toInt
    } catch {
      case e: NumberFormatException => 0
    }
  }
}
