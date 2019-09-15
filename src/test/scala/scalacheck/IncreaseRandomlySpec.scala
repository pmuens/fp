package scalacheck

import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

object IncreaseRandomlySpec extends Properties("IncreaseRandomlySpec") {
  property("increaseRandomly") = forAll { input: Int =>
    // println(s"input = $input") // debugging the input
    val result = MathUtils.increaseRandomly(input)

    result > input
  }
}
