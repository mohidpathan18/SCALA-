import breeze.linalg._
import breeze.plot._
import scala.util.Random
object ScatterPlot {
  def main(args: Array[String]): Unit = {
    val x = DenseVector(Array.fill(50)(Random.nextDouble() * 100))
    val y = DenseVector(Array.fill(50)(Random.nextDouble() * 100))
    val fig = Figure("Random Scatter Plot")
    val plt = fig.subplot(0)
    plt += scatter(
      x,
      y,
      size = _ => 0.1
    )
    plt.xlabel = "X Values"
    plt.ylabel = "Y Values"
    plt.title = "Scatter Plot of Random Data"
    fig.refresh()
    println("Scatter Plot Generated Successfully!")
  }
}