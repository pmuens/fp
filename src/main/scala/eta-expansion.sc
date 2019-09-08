// manual Eta Expansion
// (manually convert a method to a function)
def triple(i: Int) = i * 3
val tripleFn = triple _
tripleFn
tripleFn(1)
