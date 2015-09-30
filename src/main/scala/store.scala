package acme

import logging._

class Store(initialStock: Int) extends ColoredConsoleLogger with TwitterLogger {
  private var inStock = 0
  widgetsInStock = initialStock

  // properties (getters and setters)
  def widgetsInStock = inStock
  def widgetsInStock_=(newValue: Int) = {
    require(newValue >= 0, 
      {
        super[TwitterLogger].log("All out of widgets -- check back soon!");
        super[ColoredConsoleLogger].log("Out of stock!"); 
        "Out of stock!"
      })
    inStock = newValue
  }

  def order(numWidgets: Int) =  {
    super[ColoredConsoleLogger].log("Order arrived...")
    widgetsInStock -= numWidgets
    super[ColoredConsoleLogger].log(
      s"Order complete -- widgets in stock: $widgetsInStock")
  }
}
