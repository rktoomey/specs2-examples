package prasinous.unit

import org.specs2.mutable._
import prasinous._

class TrivialUnitSpec extends Specification {

  "String reverser" should {
    "reverse String" in {
      StringReverser("hello") must_== "olleh"
      StringReverser("") must beEmpty
      StringReverser(null) must beNull
    }
  }

  "Option string reverser" should  {
    "reverse Option[String]" in {
      OptionStringReverser(Some("hello")) must beSome("olleh")
      // it's in the spec, that means i expected it, right?
      OptionStringReverser(Some(null)) must beSome(null)
      OptionStringReverser(None) must beNone
    }
  }

}