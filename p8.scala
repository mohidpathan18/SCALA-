import scala.io.Source
object CSVStatistics {
  def main(args: Array[String]): Unit = {
    val file = Source.fromFile("2026.csv")
    val lines = file.getLines().toList
    val header = lines.head.split(",")
    val data = lines.tail.map(_.split(","))
    val numericColumns = List(
      "2026_Average_Age",
      "2026_Unique_Clubs_Represented",
      "Historical_Matches_Played",
      "Historical_Goals_Scored"
    )
    for (column <- numericColumns) {
      val index = header.indexOf(column)
      if (index != -1) {
        val values = data.flatMap { row =>
          try {
            Some(row(index).trim.toDouble)
          } catch {
            case _: Exception => None
          }
        }
        if (values.nonEmpty) {
          val count = values.length
          val sum = values.sum
          val mean = sum / count
          val min = values.min
          val max = values.max
          println("\n====================")
          println("Column : " + column)
          println("======================")
          println("Count   : " + count)
          println("Sum     : " + sum)
          println("Mean    : " + mean)
          println("Minimum : " + min)
          println("Maximum : " + max)
        }
      }
    }
    file.close()
  }
}