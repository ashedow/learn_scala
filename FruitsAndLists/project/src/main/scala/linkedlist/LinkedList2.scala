object LinkedListImp2 {
    abstract class LinkedList[A] {
        def isEmpty: Boolean
        def head: A
        def tail: LinkedList[A]
    }

    case class Nil[A]() extends LinkedList[A] {
        def isEmpty = true
        def head = throw new java.util.NoSuchElementException("head of empty list")
        def tail = throw new java.util.NoSuchElementException("tail of empty list")
    }

    case class Cons[A](val head: A, val tail: LinkedList[A]) extends LinkedList[A] {
        def isEmpty = false
    }

    @tailrec
    final def contains(e: A): Boolean = this match {
        case Nil() => false
        case Cons(h, t) => if (h == e) true else t.contains(e)
    }

    def add()

    def remove()

    def len()

}