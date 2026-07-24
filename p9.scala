import scala.io.Source
object HandleMissingValues {
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
          if (index < row.length && row(index).trim.nonEmpty)
            Some(row(index).trim.toDouble)
          else
            None
        }
        val mean = values.sum / values.length
        println("\n===================================")
        println("Column : " + column)
        println("Mean   : " + mean)
        println("Updated Values:")
        data.foreach { row =>
          val value =
            if (index < row.length && row(index).trim.nonEmpty)
              row(index)
            else
              mean.toString
          println(value)
        }
      }
    }
    file.close()
  }
}