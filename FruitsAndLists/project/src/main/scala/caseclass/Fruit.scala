packge caseclass

object Case class {
    class MyCaseClass

    object MyCaseClass {

        def apply(obj: Any): CaseClass = new CaseClass(obj)

        def unapply(tpe: CaseClass): Option[CaseClass]

        def toString(elem: Any): String = String.valueOf(elem)

        def canEqual(obj: Any) = obj.isInstanceOf[CaseClass]
        
        def equals(that: Any): Boolean =
            that match 
            { 
                case that: Subject => that.canEqual(this) &&  
                            this.hashCode == that.hashCode 
                case _ => false
            }

        final def ==(that: Any): Boolean = this equals that

        def hashCode: Int = { 
            val prime = 31
            var result = 1
            result = prime * result + article; 
            result = prime * result +  
                    (if (name == null) 0 else name.hashCode) 
                return result 
            }
}

object Fruits {

    sealed trait MyIntOption

    case class MySomeInt(seed: Int) extends MyIntOption

    object MySomeInt {
        def apply(seed: Int): MySomeInt = new MySomeInt(seed)
        
        def unapply(obj: MySomeInt): Option[Int] = obj.seed match {
            case Nothing => None
            case _ => obj.seed
        }

        def hashCode(seed: Int): Int = seed + 2

        def canEqual(obj: Any) = obj.isInstanceOf[MySomeInt]

        def equals(that: MySomeInt): Boolean = that match {
            case null  => false
            case that: Person => {
                that.canEqual(this) &&
                this.hashCode == that.hashCode
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

    abstract class MyIntList[Int] {
        def isEmpty: Boolean
        def head: Int
        def tail: MyIntList[Int]
    }

    case class Nil[Int]() extends MyIntList[Int] {
        def isEmpty = true
        def head = throw new java.util.NoSuchElementException("head of empty list")
        def tail = throw new java.util.NoSuchElementException("tail of empty list")
    }

    case class Cons[Int](val head: A, val tail: MyIntList[Int]) extends MyIntList[Int] {
        def isEmpty = false
    }

    @tailrec
    final def contains(e: Int): Boolean = this match {
        case Nil() => false
        case Cons(h, t) => if (h == e) true else t.contains(e)
    }

    def add()

    def remove()

    def len()

}