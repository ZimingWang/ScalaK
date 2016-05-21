package FP

/**
  * Created by wangziming on 5/21/16.
  */
object WordCountMR {

  def main(argv : Array[String]): Unit ={
    val file = List("warn 2013 msg", "warn 2012 msg",
      "error 2013 msg", "warn 2013 msg")

    def wordcount(str: String): Int = str.split(" ").count(_ == "msg")

    val num = file.map(wordcount).reduceLeft(_ + _)
    /*
    * map接受一个转换函数,返回转换结果。

      reduceLeft接受一个合并函数，依次遍历合并。

      使用高阶方法可以代替大部分需要循环的操作，使代码更清晰
    * */
    println("wordcount:" + num)

    println(wordcount("warn 2013 msg"))
  }


}

