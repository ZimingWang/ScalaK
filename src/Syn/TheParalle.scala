package Syn

/**
  * Created by wangziming on 5/22/16.
  */
object TheParalle{

  def main(ar : Array[String]): Unit ={
    val urls = List("http://scala-lang.org",
      "https://github.com/yankay/scala-tour")

    def fromURL(url: String) = scala.io.Source.fromURL(url)
      .getLines().mkString("\n")

    val t = System.currentTimeMillis()
    urls.map(fromURL(_))
    println("time: " + (System.currentTimeMillis - t) + "ms")
    urls.par.map(fromURL(_))
    println("time: " + (System.currentTimeMillis - t) + "ms")
  }

}
