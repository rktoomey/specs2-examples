package prasinous.acceptance

import org.specs2._

class InlineFunctionalDemoSpec extends Specification { def is =

  "My functional spec demo should"                          ^
    "show that only the last Result is returned"            ! {
      1 must beGreaterThan(9999)  // this MatchResult is discarded
      1 must beLessThanOrEqualTo(1) } ^
    "fail as expected when results are chained together"    ! { 1 must beGreaterThan(9999) and beLessThanOrEqualTo(1) }

}