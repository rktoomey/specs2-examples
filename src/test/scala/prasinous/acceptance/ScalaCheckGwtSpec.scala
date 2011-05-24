package prasinous.acceptance

import org.specs2._
import org.specs2.specification.gen._
import org.scalacheck._
import org.scalacheck.Gen._
import prasinous.{EuclidianGCD, BinaryGCD}

class ScalaCheckGwtSpec extends Specification with ScalaCheck { def is =

    "Testing Binary GCD calculator"                     ^
      "Given the following number n1"                   ^ number1 ^
      "And the following number n2"                     ^ number2 ^
      "When we take the greatest common denominator"    ^ gcd ^
      "Then the binary GCD matches the Euclidian GCS"   ^ result ^
                                                        end

  object number1 extends Given[Long] {
    def extract(text: String) = choose(-10L, 10L)
  }
  object number2 extends When[Long, (Long, Long)] {
    def extract(number1: Long, text: String) = for { n2 <- choose(-10L, 10L) } yield (number1, n2)
  }
  object gcd extends When[(Long, Long), BinaryGCD] {
    def extract(numbers: (Long, Long), text: String) = BinaryGCD(numbers._1, numbers._2)
  }
  object result extends Then[BinaryGCD] {
    def extract(text: String)(implicit op: Arbitrary[BinaryGCD]) = {
      check { (op: BinaryGCD) => op.gcd must_== EuclidianGCD(op.u, op.v) }
    }
  }
}