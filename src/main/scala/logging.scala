package logging

trait Logger {  
  def log(message: String) {
    println(message)
  }
}
