/**
  * Created by wangziming on 5/22/16.
  */
/*
* 并行集合支持大部分集合的功能。

在前面有一个wordcount例子，也可以用并行集合加以实现。

不增加程序复杂性，却能大幅提高利用多核的能力。
*
* */


object WordCount{
  def main(ar : Array[String]): Unit ={
    val file = List("warn 2013 msg", "warn 2012 msg",
      "error 2013 msg", "warn 2013 msg")

    def wordcount(str: String): Int = str.split(" ").count("msg" == _)

    val num = file.par.map(wordcount).par.reduceLeft(_ + _)

    println("wordcount:" + num)

  }
}

