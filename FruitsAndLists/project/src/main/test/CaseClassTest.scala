val case_ex = CaseClass()

// test toStr
case_ex.name

emily match { case Person(n, r) => println(n, r) }
(Emily,niece


case class OverrideApply private (i: Int)
object OverrideApply {
  def apply(i: Int): OverrideApply = new OverrideApply(i)
}

case class OverrideCopy private (i: Int) {
  def copy(i: Int = i): OverrideCopy = OverrideCopy(i)
}