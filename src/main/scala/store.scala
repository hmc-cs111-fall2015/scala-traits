package acme

import logging._

class Store(initialStock: Int) extends ColoredConsoleLogger with TimestampLogger {
  private var inStock = 0
  widgetsInStock = initialStock

  // properties (getters and setters)
  def widgetsInStock = inStock
  def widgetsInStock_=(newValue: Int) = {
    require(newValue >= 0, {log("Out of stock!"); "Out of stock!"})
    inStock = newValue
  }

  def order(numWidgets: Int) =  {
    log("Order arrived...")
    widgetsInStock -= numWidgets
    log(s"Order complete -- widgets in stock: $widgetsInStock")
  }
}
