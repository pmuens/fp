case class Item(name: String)

case class Cart(items: List[Item]) {
  def addItem(item: Item): Cart = {
    this.copy(items = this.items :+ item)
  }

  def removeAllItems(): Cart = {
    val newItems = List[Item]()
    this.copy(items = newItems)
  }

  override def toString: String = this.items.toString()
}

val cucumber = Item("cucumber")
val chili = Item("chili")

val cart1 = Cart(List(cucumber))
println(cart1.toString)

val cart2 = cart1.addItem(chili)
println(cart2.toString)

val cart3 = cart2.removeAllItems()
println(cart3.toString)

println("--- state of all shopping cards ---")
println(cart1.toString)
println(cart2.toString)
println(cart3.toString)



