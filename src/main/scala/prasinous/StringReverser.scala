package prasinous

object StringReverser {

  // recurse, recurse, for better or worse i must recurse

  def apply(s: String) = if (s == null || s.isEmpty) s else reverse(s, "")
  
  private def reverse(s: String, acc: String): String = if (s.isEmpty) acc else reverse(s.substring(1), s.charAt(0) + acc)
}

object OptionStringReverser {
  def apply(s: Option[String]) = s.map(StringReverser(_))
}