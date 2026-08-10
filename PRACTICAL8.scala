import breeze.linalg.{DenseVector, norm}
object KMeansExample {
  def main(args: Array[String]): Unit = {
    println("=== Pathan Mohid S102 ===")
    val data = Seq(
      DenseVector(1.0, 2.0),
      DenseVector(1.5, 1.8),
      DenseVector(5.0, 8.0),
      DenseVector(6.0, 9.0)
    )
    var centroid1 = data(0)
    var centroid2 = data(2)
    var cluster1 = Seq[DenseVector[Double]]()
    var cluster2 = Seq[DenseVector[Double]]()
    for (i <- 1 to 5) {
      cluster1 = Seq()
      cluster2 = Seq()
      for (point <- data) {
        val dist1 = norm(point - centroid1)
        val dist2 = norm(point - centroid2)
        if (dist1 < dist2)
          cluster1 :+= point
        else
          cluster2 :+= point
      }
      centroid1 = cluster1.reduce(_ + _) /:/ cluster1.length.toDouble
      centroid2 = cluster2.reduce(_ + _) /:/ cluster2.length.toDouble
    }
    println("\nCluster 1:")
    cluster1.foreach(println)
    println("\nCluster 2:")
    cluster2.foreach(println)
    println(s"\nFinal Centroids:")
    println(s"C1: $centroid1")
    println(s"C2: $centroid2")
  }
}