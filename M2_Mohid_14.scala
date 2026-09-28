import scala.io.Source
import scala.collection.mutable

object M2_Mohid_14 {

  def main(args: Array[String]): Unit = {

    val filePath =
      "E:/mohid/Scala/Mohid1/src/main/scala/lck2022_champs.csv"

    val lines = Source.fromFile(filePath).getLines().toList

    if (lines.isEmpty) {
      println("CSV file is empty.")
      return
    }

    val header = lines.head.split(",").map(_.trim)

    println("Columns in Dataset:")
    println(header.mkString(", "))

    val dateIndex =
      header.indexWhere(_.equalsIgnoreCase("date"))

    if (dateIndex == -1) {
      println("Date column not found in the CSV file.")
      return
    }

    val dailyGames = mutable.Map[String, Int]()

    for (line <- lines.tail) {

      val columns = line.split(",", -1).map(_.trim)

      if (columns.length > dateIndex) {

        val dateTime = columns(dateIndex)

        if (dateTime.length >= 10) {

          val date = dateTime.substring(0, 10)

          dailyGames(date) =
            dailyGames.getOrElse(date, 0) + 1
        }
      }
    }

    val sortedData =
      dailyGames.toSeq.sortBy(_._1)

    println()
    println("======================================")
    println("       LCK 2022 TIME SERIES ANALYSIS")
    println("======================================")

    println()
    println(f"${"Date"}%-15s${"Number of Games"}")
    println("--------------------------------------")

    for ((date, games) <- sortedData) {
      println(f"$date%-15s$games")
    }

    val totalGames =
      dailyGames.values.sum

    val numberOfDays =
      dailyGames.size

    if (numberOfDays > 0) {

      val averageGames =
        totalGames.toDouble / numberOfDays

      val maximum =
        dailyGames.maxBy(_._2)

      val minimum =
        dailyGames.minBy(_._2)

      println()
      println("======================================")
      println("              SUMMARY")
      println("======================================")

      println("Total Games       : " + totalGames)
      println("Number of Days    : " + numberOfDays)

      println(
        f"Average Games/Day : $averageGames%.2f"
      )

      println(
        "Maximum Games Day : " +
          maximum._1 +
          " (" +
          maximum._2 +
          " games)"
      )

      println(
        "Minimum Games Day : " +
          minimum._1 +
          " (" +
          minimum._2 +
          " games)"
      )
    }
  }
}