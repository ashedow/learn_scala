object Case {
    class CaseClass(val item: Int) {
        def equals(obj1: CaseClass, obj2: CaseClass): Boolean = (obj1, obj2) match {
            case (obj1, obj2) => obj1.item == obj2.item
            case _ => false
        }
    }

    object CaseClass {

        def apply(item: Int): CaseClass = new CaseClass(item)

        def unapply(obj: CaseClass): Option[Int] = Some(obj.item)

        def toString: String = this.toString

        def canEqual(obj: Any): Boolean = obj.isInstanceOf[CaseClass]

        final def ==(that: CaseClass): Boolean = this equals that

        def productPrefix: String = "CaseClass"
        def hashCode(): Int = this.hashCode
        def copy(item: Int): CaseClass = new CaseClass(item)

    }
}

object Fruits {

    sealed trait MyIntOption {
        def equals(obj1: MyIntOption, obj2: MyIntOption): Boolean = (obj1, obj2) match {
            case (MySomeInt(x), MySomeInt(y)) => x == y
            case (MyNone, MyNone) => true
            case _ => false
        }
    }

    case class MySomeInt(val seed: Int) extends MyIntOption

    case object MyNone extends MyIntOption

    object MyIntOption {
        def apply(i: Any): MyIntOption = i match {
            case i: Int => MySomeInt(i)
            case _ => MyNone
        }
        // def unapply(obj: MyIntOption): Option[Int] = obj match {
        //     case MySomeInt(x) => Some(obj.seed)
        //     case obj: MyNone => None
        // }
        // def hashCode(): Int = this.hashCode
        // def canEqual(obj: Any) = obj.isInstanceOf[MyIntOption]
        // def toString(): Option[String] = this.toString

        def getOrElse(opt: MyIntOption, default: Int): Int = opt match {
            case opt.seed => opt.seed
            case _ => -1
        }
    }
}

object LinkedListImp {
    sealed trait MyIntList 

    object MyIntList {
        def head(list: MyIntList): Int = list match {
            case x: EmptyIntList => throw new Exception("head of empty list") 
            case IntListOption(h, t) => h
        }
        def safeHead(list: MyIntList): MyIntOption = list match {
            case x: EmptyIntList => EmptyIntList
            case IntListOption(h, t) => h
        }
        def tail(list: MyIntList): Int = list match {
            case x: EmptyIntList => throw new Exception("head of empty list") 
            case IntListOption(h, t) => t
        }
        def isEmpty(list: MyIntList): Boolean = list match {
            case x: EmptyIntList => true
            case _ => false
        }
        def add(elem: Int): MyIntList = elem match {
            case IntListOption(h, t) => h + join(t)
            case EmptyIntList => EmptyIntList(elem)
        }
        def apply(elem: Int*): MyIntList = elem match {
            case list if (!list.isEmpty) => IntListOption(list.head, apply(list.tail:_*))
            case _ => EmptyIntList
        }

    }

    object EmptyIntList extends MyIntList
    case class IntListOption(val h: Int, val t: MyIntList) extends MyIntList
}