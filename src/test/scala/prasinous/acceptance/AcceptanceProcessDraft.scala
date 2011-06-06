package prasinous.acceptance

import org.specs2.Specification

class AcceptanceProcessDraft extends Specification { def is =
  "first example" ! pending ^
  "second example" ! pending
}

class AcceptanceProcessSecondDraft extends Specification { def is =
  "first example" ! e1 ^
  "second example" ! e2

  def e1 = pending
  def e2 = pending
}



