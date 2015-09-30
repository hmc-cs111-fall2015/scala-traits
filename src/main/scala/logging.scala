package logging

// a "thin interface"
trait Logger {  
  def log(message: String) {}

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
  abstract override def log(message: String) {
    println(message)
    super.log(message)
  }
}

// extending an existing trait
trait ColoredConsoleLogger extends ConsoleLogger {
  override def infoTag = Console.GREEN + super.infoTag + Console.RESET
  override def warningTag = Console.YELLOW + super.warningTag + Console.RESET
  override def errorTag = Console.RED + super.errorTag + Console.RESET
}

// mixin implementation: prepend a timestamp
trait TimestampLogger extends Logger {
  abstract override def log(message: String) {
    val date = new java.util.Date()
    super.log(s"[$date] $message")
  }
}

// concrete implementation: to Twitter
trait TwitterLogger extends Logger {
  import twitter4j._

  val twitter = new TwitterFactory().getInstance()

  abstract override def log(message: String) {
    twitter.updateStatus(message)
    super.log(message)
  }
}
