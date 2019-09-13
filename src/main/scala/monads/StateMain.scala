package monads

object StateMain extends App {
  case class GolfState(distance: Int)

  def swing(distance: Int): State[GolfState, Int] = State { oldState: GolfState =>
    val newDistance = oldState.distance + distance
    (GolfState(newDistance), newDistance)
  }

  val stateWithNewDistance: State[GolfState, Int] = for {
    _ <- swing(20)
    _ <- swing(15)
    totalDistance <- swing(0)
  } yield totalDistance

  val beginningState = GolfState(0)

  val result: (GolfState, Int) = stateWithNewDistance.run(beginningState)

  println(s"GolfState: ${result._1}")
  println(s"Distance: ${result._2 }")
}
