import breeze.linalg.{DenseVector, euclideanDistance}
object KnnExample {
  case class DataPoint(features: DenseVector[Double], label: String)
  def main(args: Array[String]): Unit = {
    val dataset = Seq(
      DataPoint(DenseVector(1.0, 2.0), "A"),
      DataPoint(DenseVector(1.5, 2.5), "A"),
      DataPoint(DenseVector(5.0, 6.0), "B"),
      DataPoint(DenseVector(5.5, 6.5), "B")
    )
    println("=== Pathan Mohid S102 ===")
    println("Training Data:")
    dataset.foreach(p => println(s"${p.features} -> ${p.label}"))
    val newPoint = DenseVector(1.8, 2.3)
    println(s"\nNew Point: $newPoint")
    var minDistance = Double.MaxValue
    var predictedLabel = ""
    for (point <- dataset) {
      val dist = euclideanDistance(newPoint, point.features)
      println(s"Distance to ${point.label}: $dist")
      if (dist < minDistance) {
        minDistance = dist
        predictedLabel = point.label
      }
    }
    println("\nResult:")
    println(s"Nearest Distance = $minDistance")
    println(s"Predicted Class = $predictedLabel")
  }
}