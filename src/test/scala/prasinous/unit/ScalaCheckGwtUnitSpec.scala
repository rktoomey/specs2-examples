package prasinous.unit

import org.specs2.mutable.Specification
import org.specs2.ScalaCheck
import org.scalacheck._
import org.scalacheck.Gen._
import prasinous.{EuclidianGCD, BinaryGCD}

// TODO: doesn't compile - can't figure out where given/when/then are coming from

class ScalaCheckGwtUnitSpec extends Specification with ScalaCheck {
  "Testing Binary GCD calculator" {
    "Given the following number n1" ! given[Long] {
      def extract(text: String) = choose(-10L, 10L)
    }
    "And the following number n2" ! when[Long, (Long, Long)] {
      def extract(number1: Long, text: String) = for {n2 <- choose(-10L, 10L)} yield (number1, n2)
    }
    "When we take the greatest common denominator" ! when[(Long, Long), BinaryGCD] {
      def extract(numbers: (Long, Long), text: String) = BinaryGCD(numbers._1, numbers._2)
    }
    "Then the binary GCD matches the Euclidian GCS " ! then[BinaryGCD] {
      def extract(text: String)(implicit op: Arbitrary[BinaryGCD]) =
        check {
          (op: BinaryGCD) => op.gcd must_== EuclidianGCD(op.u, op.v)
        }
    }
  }
}