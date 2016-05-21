/**
  * Created by wangziming on 5/21/16.
  */


object TheFP2{
  def main(argv : Array[String]): Unit ={

    val file = List("warn 2013 msg", "warn 2012 msg",
      "error 2013 msg", "warn 2013 msg")

    println("cat file | grep 'warn' | grep '2013' | wc : "
      + file.filter(_.contains("warn")).filter(_.contains("2013")).size)
  }
}


