package prasinous.unit

import org.specs2.mutable._

class NotFunctionalDemoSpec extends Specification {
  "Mutable specs" should {
    "fail on any bad expectation" in {
      e1   // fails here
      e2   // never gets here
    }
    "fail on chained bad expectations too" in {
      e3
    }
  }

  def e1 = {
    1 must beGreaterThan(9999) // this MatchResult is NOT discarded
    1 must beLessThanOrEqualTo(1)
  }

  def e2 = {
    1 must beGreaterThan(8888)  // this would fail but we never get here
  }

  def e3 = 1 must beGreaterThan(9999) and beLessThanOrEqualTo(1)
}