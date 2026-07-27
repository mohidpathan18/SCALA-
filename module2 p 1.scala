import scala.io.Source
object MovingAverageApp {
  def main(args: Array[String]): Unit = {
    val file = Source.fromFile("games.csv")
    val turns = file.getLines().drop(1).flatMap { line =>
      val cols = line.split(",")
      cols(4).trim.toDoubleOption   // turns column
    }.toList
    file.close()
    val window = 5
    val sma = turns.sliding(window)
      .map(windowData => windowData.sum / window)
      .toList
    val weights = (1 to window).map(_.toDouble)
    val weightSum = weights.sum
    val wma = turns.sliding(window).map { windowData =>
      (windowData zip weights).map { case (v, w) => v * w }.sum / weightSum
    }.toList
    val alpha = 2.0 / (window + 1)
    val ema = turns.scanLeft(0.0) { (prevEma, value) =>
      if (prevEma == 0.0) value
      else alpha * value + (1 - alpha) * prevEma
    }.tail
    println("First 10 SMA values:")
    sma.take(10).foreach(println)
    println("\nFirst 10 WMA values:")
    wma.take(10).foreach(println)
    println("\nFirst 10 EMA values:")
    ema.take(10).foreach(println)
  }
}