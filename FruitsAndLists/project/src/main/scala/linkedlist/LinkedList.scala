object LinkedListImp {
    case class LinkedList[+T]() {
        def isEmpty: Boolean
        def head: T
        def tail: LinkedList[T]

        def apply[E]( items : E* ) : LinkedList[E] = {
            if (items.isEmpty) {
                Empty
            } else {
                Node( items.head, apply(items.tail : _*) )
            }
        }

        def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
        def apply[T]() = new Nil
    }
}