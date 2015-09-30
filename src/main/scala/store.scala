package acme

class Store(initialStock: Int) {
  private var inStock = 0
  widgetsInStock = initialStock

  // properties (getters and setters)
  def widgetsInStock = inStock
  def widgetsInStock_=(newValue: Int) = {
    require(newValue >= 0, "Out of stock!")
    inStock = newValue
  }

  def order(numWidgets: Int) =  {
    widgetsInStock -= numWidgets
  }
}
