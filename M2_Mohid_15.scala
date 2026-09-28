object M2_Mohid_15 {
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3)
    val degree = 3
    println("======================================")
    println("       POLYNOMIAL FEATURES")
    println("======================================")
    println()
    println("Input Data:")
    println(numbers.mkString("[", ", ", "]"))
    println()
    println("Polynomial Features up to Degree 3")
    println("--------------------------------------")
    for (number <- numbers) {
      val features = for (power <- 1 to degree) yield {
        Math.pow(number, power).toInt
      }
      println(
        number + " -> " +
          features.mkString("[", ", ", "]")
      )
    }
    println()
    println("======================================")
    println("             FINAL RESULT")
    println("======================================")
    val polynomialFeatures = numbers.flatMap { number =>
      (1 to degree).map { power =>
        Math.pow(number, power).toInt
      }
    }

    println(
      polynomialFeatures.mkString("[", ", ", "]")
    )
  }
}