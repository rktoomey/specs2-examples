package prasinous.unit

import org.specs2.mutable._
import org.specs2.specification._
import scala.collection.mutable.{Set => MSet, HashSet => MHashSet}

/**
 * Please don't ever do this.  It's just a contrived example.  It's not far off from some of the
 * JUnit tests I encountered during my fascinating time in the J2EE world, however.
 */
class BadIdea extends Specification {

  var badIdea = MSet.empty[Int]

  override def is = args(sequential=true)^      // hmm, already a bad sign
    Step {
      println("Doing something beforehand!")
      badIdea = MHashSet.empty[Int] ++= (1 to 100).toSet
      badIdea must not be empty
    } ^
      super.is ^
        Step {
          println("Doing something afterwards!")
          badIdea.clear()
        }

  "My badly set up spec" should {
    "make use of shared mutable state" in {
      badIdea ++= (101 to 200).toSet
      badIdea must have size(200)
    }
    "make more use of shared mutable state" in {
      badIdea = badIdea.filter(_ % 2 == 0)
      badIdea must have size(100)   // this assumption depends on the test case immediately previous!
    }
    // Send help...
  }
}
