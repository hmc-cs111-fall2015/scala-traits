package acme

class Store(var widgetsInStock: Int) {
  def order(numWidgets: Int) =  {
    widgetsInStock -= numWidgets
  }
}

object Program extends App {
  final val CAPACITY = 100
  val store = new Store(CAPACITY)

  store.order(CAPACITY / 2)
  println(store.widgetsInStock)

  store.order(CAPACITY / 2)  // the store is now empty
  println(store.widgetsInStock)

  store.order(CAPACITY / 2)  // uh-oh!
  println(store.widgetsInStock)
}
