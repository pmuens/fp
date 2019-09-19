package datastructures

object TreeMain extends App {
  val t1: Tree[Double] = Leaf(1.0)
  val t2: Tree[Int] = Branch(Leaf(1), Leaf(2))
  val t3: Tree[Int] = Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(3), Leaf(4)))
  println("t1")
  println(t1)
  println()
  println("t2")
  println(t2)
  println()
  println("t3")
  println(t3)
  println()

  println("Tree.size(t3)")
  println(Tree.size(t3))
  println()

  println("Tree.maximum(t3)")
  println(Tree.maximum(t3))
  println()

  println("Tree.depth(t3)")
  println(Tree.depth(t3))
  println()

  println("Tree.map(t3)(_ * 2)")
  println(Tree.map(t3)(_ * 2))
  println()

  println("Tree.sizeViaFold(t3)")
  println(Tree.sizeViaFold(t3))
  println()

  println("Tree.maximumViaFold(t3)")
  println(Tree.maximumViaFold(t3))
  println()

  println("Tree.depthViaFold(t3)")
  println(Tree.depthViaFold(t3))
  println()

  println("Tree.mapViaFold(t3)(_ * 2)")
  println(Tree.mapViaFold(t3)(_ * 2))
  println()
}
