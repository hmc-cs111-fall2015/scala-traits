package logging

// a "thin interface"
trait Logger {  
  def log(message: String)    // this method is abstract

  def infoTag    = "[info]"
  def warningTag = "[warning]"
  def errorTag   = "[error]"

  // these methods are implemented in terms of the abstract method
  def info(message: String) = log(s"$infoTag $message")
  def warning(message: String) = log(s"$warningTag $message")
  def error(message: String) = log(s"$errorTag $message")
}

// concrete implementation: to console
trait ConsoleLogger extends Logger {
  override def log(message: String) {
    println(message)
  }
}

// extending an existing trait
trait ColoredConsoleLogger extends ConsoleLogger {
  override def infoTag = Console.GREEN + super.infoTag + Console.RESET
  override def warningTag = Console.YELLOW + super.warningTag + Console.RESET
  override def errorTag = Console.RED + super.errorTag + Console.RESET
}
