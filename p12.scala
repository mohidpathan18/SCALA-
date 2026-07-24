import scala.io.Source
import java.io.PrintWriter
object OneHotEncoding {
  def main(args: Array[String]): Unit = {
    val file = Source.fromFile("netflix_titles.csv")
    val lines = file.getLines().toList
    val header = lines.head.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1)
    val data = lines.tail.map(_.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1))
    val typeIndex = header.indexOf("type")
    val writer = new PrintWriter("netflix_onehot.csv")
    writer.println(header.mkString(",") + ",Movie,TV_Show")
    println("One-Hot Encoded Data")
    println("----------------------------------------")
    data.foreach { row =>
      if (row.length > typeIndex) {
        val movie =
          if (row(typeIndex).trim == "Movie") 1 else 0
        val tvShow =
          if (row(typeIndex).trim == "TV Show") 1 else 0
        writer.println(row.mkString(",") + s",$movie,$tvShow")
        println(
          row(0) + " -> Movie: " + movie + "  TV_Show: " + tvShow
        )
      }
    }
    writer.close()
    file.close()
    println("\nOne-Hot Encoding Completed Successfully!")
    println("Output file created: netflix_onehot.csv")
  }
}