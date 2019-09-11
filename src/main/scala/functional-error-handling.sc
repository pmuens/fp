// NOTE: one might also use `Nil` for lists
// NOTE: use these techniques to wrap `null` values (e.g. coming from Java libraries)

// using exceptions --> BAD!
@throws(classOf[Exception])
def makeIntException(number: String): Int = {
  try {
    number.trim.toInt
  } catch {
    case e: Error => throw e
  }
}

// using `Option`
def makeIntOption(number: String): Option[Int] = {
  try {
    Some(number.trim.toInt)
  } catch {
    case e: Exception => None
  }
}
val resOption = for {
  int1 <- makeIntOption("1")
  int2 <- makeIntOption("2")
  int3 <- makeIntOption("three")
} yield int1 + int2 + int3

// using `Try`
import scala.util.{Try, Success, Failure}
def makeIntTry(number: String): Try[Int] = {
  try {
    Success(number.trim.toInt)
  } catch {
    case e: Exception => Failure(e)
  }
}
val resTry = for {
  int1 <- makeIntTry("1")
  int2 <- makeIntTry("2")
  int3 <- makeIntTry("three")
} yield int1 + int2 + int3

// using `Either`
def makeIntEither(number: String): Either[String, Int] = {
  try {
    Right(number.trim.toInt)
  } catch {
    case e: Exception => Left(e.getMessage)
  }
}
val resEither = for {
  int1 <- makeIntEither("1")
  int2 <- makeIntEither("2")
  int3 <- makeIntEither("three")
} yield int1 + int2 + int3
