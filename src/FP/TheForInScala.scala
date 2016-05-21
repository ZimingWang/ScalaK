package FP

/**
  * Created by wangziming on 5/21/16.
  */
object TheForInScala {

  def main(ar : Array[String]): Unit ={
    val file = List("warn 2013 msg", "warn 2012 msg",
      "error 2013 msg", "warn 2013 msg")

    def wordcount(str: String): Int = str.split(" ").count("msg" == _)

    val counts =
      for (ar <- file)
        yield wordcount(ar)

    val num = counts.reduceLeft(_ + _)

    println("wordcount:" + num)


  }

}
/*
* 循环语句是指令式编程的常见语句，Scala对其加以改进，成为适应函数式风格的利器。

For循环也是有返回值的，返回的是一个List。在每一轮迭代中加入yield，yield后的值可以加入到List中。

这个例子是使用for循环代替map函数。
*
* */