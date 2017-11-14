class Publication(val title: String)
class Book(title: String) extends Publication(title)
class Article(title: String, val topics: List[String]) extends Publication(title)

object Library {
  val books: Set[Book] =
    Set(
      new Book("Programming in Scala"),
      new Book("Scala by Example"),
      new Book("Functional Scala"),
      new Book("Structure and Interpreration of Computer Programs")
    )

  def printBookList(info: Book => AnyRef) = {
    for (book <- books) println(info(book))
  }
}

object Thesis {
  val articles: Set[Article] =
    Set(
      new Article("Bees in Africa", List("Bees", "Africa", "Insects")),
      new Article("Ants in Australia", List("Ants", "Australia", "Insects"))
    )

  def printArticleList(info: Article => AnyRef) = {
    for (article <- articles) println(info(article))
  }
}

object Customer extends App {
  def getTitle(p: Publication): String = p.title
  def getTopics(p: Article): List[String] = p.topics
  Library.printBookList(getTitle)
  Thesis.printArticleList(getTitle)
  Thesis.printArticleList(getTopics)

  val b = new Book("Sample Book")
  val bIsPublication: Boolean = b.isInstanceOf[Publication]
  println(s"book is a publication: $bIsPublication")
}
