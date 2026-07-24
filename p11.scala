import scala.io.Source
object WordFrequencyCounter {
  def main(args: Array[String]): Unit = {
    val file = Source.fromFile("netflix_titles.csv")
    val lines = file.getLines().toList
    val data = lines.drop(1)
    val descriptions = data.flatMap { line =>
      val columns = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1)
      if (columns.length > 11)
        Some(columns(11))
      else
        None
    }
    val words = descriptions
      .flatMap(_.toLowerCase.split("\\W+"))
      .filter(_.nonEmpty)
    val wordCounts = words.groupBy(identity).view.mapValues(_.size).toMap
    println("Top 20 Most Frequent Words")
    println("--------------------------------")
    wordCounts.toSeq
      .sortBy(-_._2)
      .take(20)
      .foreach { case (word, count) =>
        println(f"$word%-15s -> $count")
      }
    file.close()
  }
}