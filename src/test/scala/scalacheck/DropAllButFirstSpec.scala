package scalacheck

import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}

// algorithms to generate int lists
object GenIntSeq {
  val g1to5: Gen[List[Int]] = Gen.containerOf[List, Int](Gen.choose(1, 5))

  val favorTwos: Gen[Int] = Gen.frequency(
    (1, 1),
    (4, 2),
    (1, 3),
    (1, 4),
    (1, 5)
  )
  val genMostlyTwos: Gen[List[Int]] = Gen.containerOf[List, Int](favorTwos)

  val littleList: List[Int] = scala.util.Random.shuffle(List(1, 2, 3, 4, 5, 6, 7, 8, 9))
  val littleListGen: Gen[List[Int]] = Gen.someOf(littleList).map(_.toList)
}

object DropAllButFirstSpec extends Properties("DropAllButFirstSpec") {
  val NUM_TO_DROP = 2

  property("dropAllButFirst") = forAll(GenIntSeq.genMostlyTwos) { input: List[Int] =>
    // println(s"input = $input") // debugging the input
    val result = ListUtils.dropAllButFirst(input, 2)

    val numMatches = input.count(_ == NUM_TO_DROP)
    if (numMatches == 0) {
      input == result
    } else if (numMatches == 1) {
      input == result
    } else {
      val element1PositionOriginal = input.indexOf(NUM_TO_DROP)
      val element1PositionFinal = result.indexOf(NUM_TO_DROP)
      val numOccurrencesInResult = result.count(_ == NUM_TO_DROP)

      val locationOfFirstOccurrenceInInput = input.indexOf(NUM_TO_DROP)
      val (inputBefore, inputAfter) = input.splitAt(locationOfFirstOccurrenceInInput)
      val inputAfterTail = inputAfter.tail
      val inputAfterFiltered = inputAfterTail.filter(_ != NUM_TO_DROP)

      val locationOfFirstOccurrenceInResult = result.indexOf(NUM_TO_DROP)
      val (resultBefore, resultAfter) = result.splitAt(locationOfFirstOccurrenceInResult)
      val resultAfterTail = resultAfter.tail

      element1PositionOriginal == element1PositionFinal &&
        numOccurrencesInResult == 1 &&
        inputBefore == resultBefore &&
        inputAfterFiltered == resultAfterTail
    }
  }
}
