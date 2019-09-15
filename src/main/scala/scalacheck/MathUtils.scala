package scalacheck

object MathUtils {
  def increaseRandomly(i: Int): Long = {
    val randomNum = getRandomIntFrom1To100

    // old implementation which failed when `i` was `Int.MaxValue`
    i + randomNum

    // fix for `i` values which are `Int.MaxValue`
    i + randomNum.toLong
  }

  private def getRandomIntFrom1To100: Int = scala.util.Random.nextInt(100) + 1
}
