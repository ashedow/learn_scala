// packge caseclass

object Case {
    class CaseClass(item: Int)

    object CaseClass {

        def apply(item: Int): CaseClass = new CaseClass(item)

        def unapply(obj: CaseClass): Option[CaseClass] = Some(obj.item)

        def toString: String = this.toString
        
        def equals(that: CaseClass): Boolean = that match { 
            case that => this.item == that.item 
            case _ => false
        }

        def canEqual(obj: Any): Boolean = obj.isInstanceOf[CaseClass]

        // def equals(obj: Any): Boolean = (this, that) match {
        //     case that: CaseClass => {
        //         this.item == that.item
        //     }
        //     // case (CaseClass(this.item), CaseClass(that.item)) => this.item == that.item
        //     case _ => false
        // }

        final def ==(that: CaseClass): Boolean = this equals that

        def productPrefix: String = "CaseClass"
        def hashCode(): Int = this.hashCode
        def copy(item: Int): CaseClass = new CaseClass(item)

    }
}

object Fruits {

    sealed trait MyIntOption

    case class MySomeInt(seed: Int) extends MyIntOption

    case object MyNone extends MyIntOption

    def apply(i: Any): MyIntOption = i match {
        case i: Int => MySomeInt(i)
        case _ => MyNone
    }
    def unapply(obj: MyIntOption): Option[Int] = obj match {
        case MySomeInt(x) => Some(obj.seed)
        case obj: MyNone => null
    }
    def hashCode(): Int = this.hashCode
    def canEqual(obj: Any) = obj.isInstanceOf[MyIntOption]
    def equals(obj1: MyIntOption, obj2: MyIntOption): Boolean = (obj1, obj2) match {
            case (MySomeInt(x), MySomeInt(y)) => x == y
            case (MyNone, MyNone) => true
            case _ => false
        }
    def toString(): Option[String] = this.toString

}

object LinkedListImp {

    // case class MyIntList(elem: Int)

    // object MyIntList {
        // val isEmpty: Boolean
        // val head: Int
        // val tail: MyIntList

        // def apply(elem: Option[Int, Array[Int]]): Option[MyIntList] = elem match {
        //     // case Nil = 
        //     case Int => new MyIntList(elem)
        //     // case Array[_,_*] => MyIntList(elem)
        //     case _ => "empty or unexpected param"
        // }

        // def add(elem: Int): MyIntList = {
        //     this.tail = MyIntList(elem)
        // }
    // }



    sealed trait MyIntList {

    object MyIntList {
        def head: Int
        def tail: MyIntList
        def isEmpty: Boolean
        def add(element: Int): MyIntList
        def apply()
    }

    object EmptyIntList extends MyIntList {
        def head: Int = throw new NoSuchElementException
        def tail: MyIntList = throw new NoSuchElementException
        def isEmpty: Boolean = true
        def add(element: Int): MyIntList = new IntListOption(element, this)
        // adds in the beginning and puts the current list in the tail
    }

    case class IntListOption(h: Int, t: MyIntList) extends MyIntList {
        def head: Int = h
        def tail: MyIntList = t
        def isEmpty: Boolean = false
        def add(element: Int): MyIntList = new IntListOption(element, this)
    }






    // case class MyIntList(elem: Int*)

//     class Nil() extends MyIntList { WTF !!!!!!!!!
//         def isEmpty = true
//         def head = throw new java.util.NoSuchElementException("head of empty list")
//         def tail = throw new java.util.NoSuchElementException("tail of empty list")
//     }

//     class Cons(val head: A, val tail: MyIntList) extends MyIntList {
//         def isEmpty = false
//     }

//     abstract class MyIntList {
//         def isEmpty: Boolean
//         def head: Int
//         def tail: MyIntList

//     }

}
