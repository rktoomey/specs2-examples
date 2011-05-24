package prasinous.unit

import org.specs2.mutable._
import org.specs2.specification._

class BetterIdea extends Specification {

  // happens BEFORE each use case
  trait testData extends Scope {
    println("Setting up data JUST for you and your little dog, my pretty.")
    val betterIdea = (1 to 100).toSet
    betterIdea must have size(100)
  }

  object setupData extends Before {
    var betterIdea = Set.empty[Int]
    def before {
      betterIdea ++= (1 to 100).toSet
      betterIdea must have size(100)
    }
  }

  "My better spec using contexts" should {
    "force each use case to have its own immutable data" in new testData {
      val newSet = betterIdea ++ (101 to 200).toSet
      newSet must have size(200)
    }
    "get rid of expectations that depend on shared state" in new testData {
      val anotherNewSet = betterIdea.filter(_ % 2 == 0)  // technically a new ArrayBuffer and then a new Set
      anotherNewSet must have size(50)  // changed expectation no longer depends on shared state!
    }
  }

  "or do it with a context instead" >> {
    "now my example will be executed inside the setupData context" >> setupData {
      val newSet = setupData.betterIdea ++ (101 to 200).toSet
      newSet must have size (200)
    }
  }
}