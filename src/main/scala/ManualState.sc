// manually managing state with a case class
case class GolfState(strokes: List[Int])

def nextStroke(state: GolfState, distance: Int): GolfState = {
  GolfState(distance :: state.strokes)
}

val golfState0 = GolfState(Nil)
val golfState1 = nextStroke(golfState0, 20)
val golfState2 = nextStroke(golfState1, 15)
val golfState3 = nextStroke(golfState2, 0)

println(golfState3)

// state management is like pushing to a list
def push[A](xs: List[A], x: A): List[A] = {
  x :: xs
}

def pop[A](xs: List[A]): (A, List[A]) = {
  (xs.head, xs.tail)
}

val state0: List[Int] = Nil
val state1 = push(state0, 20)
val state2 = push(state1, 15)
val state3 = push(state2, 0)

println(state3)

// a naive state monad
case class State(value: Int) {
  def map(f: Int => Int): State = {
    State(f(value))
  }

  def flatMap(f: Int => State): State = {
    val newState = f(value)
    State(newState.value)
  }
}

val res = for {
  a <- State(20)
  b <- State(a + 15) // we need to manually carry over the state
  c <- State(b + 0)
} yield c
println(res)
