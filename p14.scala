import breeze.linalg._
import breeze.plot._
import scala.util.Random
object HistogramExample {
  def main(args: Array[String]): Unit = {
    val randomData = DenseVector(Array.fill(100)(Random.nextDouble() * 100))
    val fig = Figure("Histogram Example")
    val plt = fig.subplot(0)
    plt += hist(randomData)
    plt.xlabel = "Values"
    plt.ylabel = "Frequency"
    plt.title = "Histogram of Random Data"
    fig.refresh()
    println("Histogram Generated Successfully!")
  }
}