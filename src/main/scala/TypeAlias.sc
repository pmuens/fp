import scala.util.Try

// this makes it possible to "replace" the `Try` return type with `IO`
// NOTE: one can also define IO-specific types such as `FsIO`, `NetIO`, `DbIO` etc.
type IO[A] = Try[A]

def using[A <: { def close(): Unit }, B](resource: A)(f: A => B): B = {
  try {
    f(resource)
  } finally {
    resource.close()
  }
}

// this function returns the `IO` type
def readTextFile(file: String): IO[String] = {
  Try {
    val lines = using(io.Source.fromFile(file)) { source =>
      (for (line <- source.getLines) yield line).toList
    }
    lines.mkString("\n")
  }
}
