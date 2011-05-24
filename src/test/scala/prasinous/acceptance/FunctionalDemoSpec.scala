package prasinous.acceptance

import org.specs2._

class FunctionalDemoSpec extends Specification { def is =

  "My functional spec demo should"                          ^
    "show that only the last Result is returned"            ! e1 ^
    "fail as expected when results are chained together"    ! e2

  def e1 = {
    1 must beGreaterThan(9999)  // this MatchResult is discarded
    1 must beLessThanOrEqualTo(1)
  }

  // this fails as expected
  def e2 = 1 must beGreaterThan(9999) and beLessThanOrEqualTo(1)

}