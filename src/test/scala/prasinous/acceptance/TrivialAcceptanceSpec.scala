package prasinous.acceptance

import org.specs2._
import prasinous._

class TrivialAcceptanceSpec extends Specification { def is =

  "This is a specification to check reversing Strings"      ^
                                                            p^
  "StringReverser should"                                   ^
    "reverse a String"                                      ! e1 ^
    "leave an empty String unaffected"                      ! e2 ^
    "not fall down snivelling when someone feeds it null"   ! e3 ^
                                                            p^
  "OptionStringReverser should"                             ^
    "reverse Option[String]"                                ! e4 ^
    "reverse None"                                          ! e5 ^
    "Damn it, will someone please fix the universe?"        ! e6


  def e1 = StringReverser("hello") must_== "olleh"
  def e2 = StringReverser("") must beEmpty
  def e3 = StringReverser(null) must beNull
  def e4 = OptionStringReverser(Some("hello")) must beSome("olleh")
  def e5 = OptionStringReverser(None) must beNone
  def e6 = OptionStringReverser(Some(null)) must beSome(null)
}