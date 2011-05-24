package prasinous.unit

import org.specs2.mutable._
import prasinous._

class FailedExpectationsSpec extends Specification {

  "Bad expectations" should {
    "fail loudly" in {
      StringReverser("hello") must_== "goodbye"
    }
  }

}