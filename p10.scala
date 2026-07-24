import scala.io.Source

object FilterRows {

  def main(args: Array[String]): Unit = {

    // Read CSV file
    val file = Source.fromFile("2026.csv")

    val lines = file.getLines().toList

    val header = lines.head.split(",")

    val data = lines.tail.map(_.split(","))

    // Column to filter
    val columnName = "Historical_Goals_Scored"

    // Threshold
    val threshold = 30

    val index = header.indexOf(columnName)

    println("Countries where " + columnName + " > " + threshold)
    println("------------------------------------------------")

    data.foreach { row =>

      if (index < row.length) {

        try {

          val value = row(index).trim.toDouble

          if (value > threshold) {
            println(row.mkString(", "))
          }

        } catch {
          case _: Exception =>
        }

      }

    }

    file.close()
  }

}