packge caseclass

object Case class {
    class CaseClass

    object CaseClass {

        def apply(obj: Int): CaseClass = new CaseClass(obj)

        def unapply(tpe: CaseClass): Option[CaseClass]

        def toString(elem: Int): String = String.valueOf(elem)

        def canEqual(obj: Int) = obj.isInstanceOf[CaseClass]
        
        def equals(that: Int): Boolean = that match { 
            case that: CaseClass => that.canEqual(this) &&  
                 this.hashCode == that.hashCode 
            case _ => false
        }

        final def ==(that: Int): Boolean = this equals that

        def hashCode: Int
}

object Fruits {

    sealed trait MyIntOption

    case class MySomeInt(seed: Int) extends MyIntOption

    object MySomeInt {
        def apply(seed: Int): MySomeInt = new MySomeInt(seed)
        
        def unapply(obj: MySomeInt): Option[Int] = obj.seed

        def hashCode: Int = super.hashCode

        def canEqual(obj: Any) = obj.isInstanceOf[MySomeInt]

        def equals(that: MySomeInt): Boolean = that match {
            case that: MySomeInt => {
                that.canEqual(this) &&
                this.hashCode == that.hashCode &&
                this.seed == that.seed
            }
            case _ => false
        }
        def toString(seed: Int): Option[String] = if (seed == 0) "" else seed.toString

        def copy(obj: MySomeInt): MySomeInt = new MySomeInt(obj.seed)
    }

    case class MyNone extends MyIntOption

    object MyNone
}

object LinkedListImp {

    case class MyIntList(elem: Int*)

    case class Nil() extends MyIntList {
        def isEmpty = true
        def head = throw new java.util.NoSuchElementException("head of empty list")
        def tail = throw new java.util.NoSuchElementException("tail of empty list")
    }

    case class Cons(val head: A, val tail: MyIntList) extends MyIntList {
        def isEmpty = false
    }

    object MyIntList {
        def isEmpty: Boolean
        def head: Int
        def tail: MyIntList

        def apply(elem: Int*): MyIntList = elem match {
            case elem.isEmpty = Unit()
            case _ = Cons(a.head, apply(a.tail: _*))
        }
    }

}
