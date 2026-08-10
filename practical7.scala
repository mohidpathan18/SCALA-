import breeze.linalg.{DenseVector, euclideanDistance}
import scala.io.Source
object KnnWithCSV {
  case class DataPoint(features: DenseVector[Double], label: String)
  def loadCSV(path: String): Seq[DataPoint] = {
    Source.fromFile(path)
      .getLines()
      .drop(1)
      .map { line =>
        val cols = line.split(",")
        val features = DenseVector(cols.dropRight(1).map(_.toDouble))
        val label = cols.last
        DataPoint(features, label)
      }.toSeq
  }
  def main(args: Array[String]): Unit = {
    println("=== Pathan Mohid S102 ===")
    val dataset = loadCSV("D:/mohid/SCALA/krzy mohid/src/main/scala/cluster.csv")
    println("\nDataset:")
    dataset.foreach(d => println(s"${d.features} -> ${d.label}"))
    val newPoint = DenseVector(2.0, 3.0)
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