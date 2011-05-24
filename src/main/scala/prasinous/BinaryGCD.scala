package prasinous

case class BinaryGCD(u: Long, v: Long) {
  def gcd: Long = (u.abs, v.abs) match {
    case (u, v) if (u == v) || (u == 0) || (v == 0) => u | v
    case (u, v) if u % 2 == 0 && v % 2 == 0 => 2 * BinaryGCD(u / 2, v / 2).gcd
    case (u, v) if u % 2 == 0 => BinaryGCD(u / 2, v).gcd
    case (u, v) if v % 2 == 0 => BinaryGCD(u, v / 2).gcd
    case (u, v) => BinaryGCD((v - u) / 2, u).gcd
  }
}

object EuclidianGCD {
  def apply(a: Long, b: Long): Long = (a.abs, b.abs) match {
    case (a, b) if b == 0 => a
    case (a, b) => apply(b, a % b)
  }
}