import breeze.linalg._
object SubMatrixSum {
  def main(args: Array[String]): Unit = {
    val matrix = DenseMatrix(
      (1.0, 2.0, 3.0, 4.0),
      (5.0, 6.0, 7.0, 8.0),
      (9.0, 10.0, 11.0, 12.0),
      (13.0, 14.0, 15.0, 16.0)
    )
    println("Original Matrix:")
    println(matrix)
    val subMatrix = matrix(1 to 2, 1 to 3)
    println("\nSub Matrix:")
    println(subMatrix)
    val rowSums = sum(subMatrix(*, ::))
    val colSums = sum(subMatrix(::, *))
    println("\nRow Sums:")
    println(rowSums)
    println("\nColumn Sums:")
    println(colSums)
  }
}