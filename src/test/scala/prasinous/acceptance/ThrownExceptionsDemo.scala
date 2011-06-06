package prasinous.acceptance

import org.specs2._
import org.specs2.matcher.ThrownExpectations

class ThrownExceptionsDemo extends Specification with ThrownExpectations { def is =

  "My functional spec demo should"                          ^
    "show that only the last Result is returned"            ! e1 ^
    "fail as expected when results are chained together"    ! e2

  def e1 = {
    1 must beGreaterThan(9999)  // fails because ThrownExpectations was mixed in
    1 must beLessThanOrEqualTo(1)
  }

  // fails because first assumption in chain is bad
  def e2 = 1 must beGreaterThan(9999) and beLessThanOrEqualTo(1)
}