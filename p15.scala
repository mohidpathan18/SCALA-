import breeze.linalg._
import breeze.plot._
import scala.io.Source
object LineGraphExample {
  def main(args: Array[String]): Unit = {
    val file = Source.fromFile("random_stock_market_dataset.csv")
    val lines = file.getLines().drop(1).toList
    val prices = lines.flatMap { line =>
      val cols = line.split(",")
      try {
        Some(cols(4).toDouble)
      } catch {
        case _: Exception => None
      }
    }
    file.close()
    val x = DenseVector((0 until prices.length).map(_.toDouble).toArray)
    val y = DenseVector(prices.toArray)
    val fig = Figure("Stock Market Trend")
    val plt = fig.subplot(0)
    plt += plot(x, y)
    plt.xlabel = "Days"
    plt.ylabel = "Close Price"
    plt.title = "Stock Market Closing Price Trend"
    fig.refresh()
    println("Line Graph Generated Successfully!")
  }
}