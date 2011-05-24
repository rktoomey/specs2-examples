package prasinous.unit

import org.specs2.mutable._

class WithJUnitSpec extends SpecificationWithJUnit {
  "My spec" should {
    "run in JUnit too" in {
      // some use case
      success
    }
  }
}