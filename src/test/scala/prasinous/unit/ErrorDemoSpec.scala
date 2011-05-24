package prasinous.unit

import org.specs2.mutable._
import java.lang.Error

class ErrorDemoSpec extends Specification {

  "My shoddy Fibonacci sequence implementation" should  {
    "work anyway" in {
      fibonacci(0, 21) must contain(0, 1, 1, 2, 3, 5, 8, 13, 21).only
    }
  }

  def fibonacci(x: Int, y: Int): List[Int] = throw new Error("Bored now.")
}