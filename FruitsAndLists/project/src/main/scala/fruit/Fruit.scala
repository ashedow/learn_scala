object Fruits {
    abstract class Fruit(name: String)

    trait Seed {
        val seed: Int
    }

    case class Apple extends Fruit with Seed
    case class EmptyApple extends Fruit

    val apple: Fruit = Apple(10)
    val emptyApple: Fruit = EmptyApple()

    def isEmptyApple (apple: Fruit) = apple match {
        case Fruit(_,EmptyApple(true)) => true
        case _ => false
    }
}