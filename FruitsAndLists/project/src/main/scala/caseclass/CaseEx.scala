packge caseclass

// class with case class features
abstract class CaseClass {

    // apply method allows us to create an object without new keyword.
    def apply(obj: Any): CaseClass = new CaseClass(obj)

    // unaply method which is used for pattern matching. extractor
    // The Scala standard is that an unapply method returns the case class 
    // constructor fields in a tuple that’s wrapped in an Option.
    // The “tuple” part of the solution was shown in the previous lesson.
    def unapply(tpe: CaseClass): Option[CaseClass]


    // toString method
    def toString(elem: Any): String = String.valueOf(elem)

    // Equals and Hashcode are implemented out of the box
    def canEqual(obj: Any) = obj.isInstanceOf[CaseClass]
    
    // def equals(that: Any): Boolean = this eq that.asInstanceOf[AnyRef]
    def equals(that: Any): Boolean =
        that match 
        { 
            case that: Subject => that.canEqual(this) &&  
                        this.hashCode == that.hashCode 
            case _ => false
        }

    final def ==(that: Any): Boolean = this equals that


    // hashCode method  calls scala.runtime.ScalaRunTime._hashCode which is defined as
    // def _hashCode(x: Product): Int = { val arr = x.productArity var code = arr var i = 0 while (i < arr) { val elem = x.productElement(i) code = code * 41 + (if (elem == null) 0 else elem.hashCode()) i += 1 } code }
    // def hashCode(): Int = i % 1024
    def hashCode: Int = { 
        val prime = 31
        var result = 1
        result = prime * result + article; 
        result = prime * result +  
                (if (name == null) 0 else name.hashCode) 
            return result 
        } 
    }

    // Copy method
    // The copy method of case class allows full copy as well as copy using custom values.
    def copy(obj: Any): CaseClass = new CaseClass(obj)

}