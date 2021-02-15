import org.scalatest._

object Solution extends App {
    def countFamily(numRows: Int, reservations: String): Int = {
      val defaultPlace: Int = 3
      val singleRow: String = "ABC DEFG HJK"
      val allPlace = collection.mutable.Map() ++ (1 to 3).map( x => (x, singleRow)).toMap
      val reservedPlace = dropExistedPlace(allPlace, reservations)
      println(reservedPlace)
      
      if (reservations != null && !reservations.isEmpty) {
        val reservedPlace = dropExistedPlace(reservations)
        (numRows - reservedPlace.size) * defaultPlace + reservedPlace.sum
      } else {
        numRows * defaultPlace
      }
  }

    def dropExistedPlace(allPlace: Map[Int, String], reservations: String): List[Int] = {
        // val singleRow: String = "ABC DEFG HJK"
        val familySizeRegexp = """\w{3,}""".r
        val placeRegexp = """(\d)([A-Z])""".r
        str.split(' ').foreach{ case placeRegexp(k, v) => (allPlace(k.toInt) = allPlace(k.toInt).replaceAll(v, ""))}

        allPlace.values.map(x => familySizeRegexp.findAllIn(x).length)
        // reservations.split(' ').map{ case placeRegexp(k, v) =>
        // Map(k.toInt, familySizeRegexp.findAllIn(singleRow.replaceAll(v, "")).toList.length)}.toMap

        reservations.split(' ').collect{ case placeRegexp(k, v) =>
        (k.toInt, singleRow.replaceAll(v, ""))}
    }

  println(countFamily(1, "1D 1G"))
//   assert(countFamily(1, "1D 1G") == 2)
//   assert(countFamily(3, "1D 2D 3D") == 9)
//   assert(countFamily(2, "") == 6)
//   assert(countFamily(1, "1F 1G") == 2)

}

