package prasinous.acceptance

import org.specs2._
import org.specs2.execute.Result
import org.specs2.specification._
import prasinous.BinaryGCD

class GivenWhenThenSpec extends Specification { def is =

  "A given-when-then example for GCD"                   ^
    "Given the following number: ${4}"                  ^ number1 ^
    "And the following number: ${2}"                    ^ number2 ^
    "Then the greatest common denominator is ${2}"      ^ result ^
                                                        end

  object number1 extends Given[Long] {
    def extract(text: String): Long = extract1(text).toLong
  }
  object number2 extends When[Long, BinaryGCD] {
    def extract(number1: Long, text: String) = BinaryGCD(number1, extract1(text).toLong)
  }
  object result extends Then[BinaryGCD] {
    def extract(b: BinaryGCD, text: String): Result = b.gcd must_== extract1(text).toLong
  }


}