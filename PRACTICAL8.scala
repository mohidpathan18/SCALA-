import breeze.linalg.{DenseVector, norm}
import scala.io.Source
object KMeansWithCSV {
  def loadCSV(path: String): Seq[DenseVector[Double]] = {
    Source.fromFile(path)
      .getLines()
      .drop(1)
      .map(line => DenseVector(line.split(",").map(_.toDouble)))
      .toSeq
  }
  def main(args: Array[String]): Unit = {
    println("=== Pathan Mohid S102 ===")
    val data = loadCSV("D:/mohid/SCALA/krzy mohid/src/main/scala/cluster.csv")
    var c1 = data(0)
    var c2 = data(1)
    var cluster1 = Seq[DenseVector[Double]]()
    var cluster2 = Seq[DenseVector[Double]]()
    for (i <- 1 to 5) {
      cluster1 = Seq()
      cluster2 = Seq()
      for (point <- data) {
        val d1 = norm(point - c1)
        val d2 = norm(point - c2)
        if (d1 < d2) cluster1 :+= point
        else cluster2 :+= point
      }
      c1 = cluster1.reduce(_ + _) /:/ cluster1.length.toDouble
      c2 = cluster2.reduce(_ + _) /:/ cluster2.length.toDouble
    }
    println("\nCluster 1:")
    cluster1.foreach(println)
    println("\nCluster 2:")
    cluster2.foreach(println)
    println("\nFinal Centroids:")
    println(s"C1: $c1")
    println(s"C2: $c2")
  }
}