import breeze.linalg._
object MatrixOperations {
  def main(args: Array[String]): Unit = {
    val matrix1 = DenseMatrix(
      (1.0, 2.0, 3.0),
      (4.0, 5.0, 6.0),
      (7.0, 8.0, 9.0)
    )
    val matrix2 = DenseMatrix(
      (9.0, 8.0, 7.0),
      (6.0, 5.0, 4.0),
      (3.0, 2.0, 1.0)
    )
    println("Matrix 1:")
    println(matrix1)
    println("\nMatrix 2:")
    println(matrix2)
    println("\nAddition:")
    println(matrix1 + matrix2)
    println("\nSubtraction:")
    println(matrix1 - matrix2)
    println("\nElement-wise Multiplication:")
    println(matrix1.mapPairs { case ((i, j), value) =>
      value * matrix2(i, j)
    })
    println("\nElement-wise Division:")
    println(matrix1.mapPairs { case ((i, j), value) =>
      value / matrix2(i, j)
    })
  }
}