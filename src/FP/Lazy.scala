package FP

/**
  * Created by wangziming on 5/21/16.
  */


object Lazy{
class ScalaCurrentVersion(val url: String) {
  lazy val source = {
    println("fetching from url...")
    scala.io.Source.fromURL(url).getLines().toList
  }
  lazy val majorVersion = source.find(_.contains("version.major"))
  lazy val minorVersion = source.find(_.contains("version.minor"))
}

  def main(ar : Array[String]): Unit ={
    val version = new ScalaCurrentVersion(
      "https://raw.github.com/scala/scala/master/build.number")
    println("get scala version from " + version.url)
    version.majorVersion.foreach(println _)
    version.minorVersion.foreach(println _)
  }

}
