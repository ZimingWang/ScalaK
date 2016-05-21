package FP

/**
  * Created by wangziming on 5/21/16.
  */
object TailRecursion {
  def main(argv : Array[String]): Unit ={
    val file = List("warn 2013 msg", "warn 2012 msg",
      "error 2013 msg", "warn 2013 msg")

    def wordcount(str: String): Int = str.split(" ").count("msg" == _)

    def foldLeft(list: List[Int])(init: Int)(f: (Int, Int) => Int): Int = {
      list match {
        case List() => init
        case head :: tail => foldLeft(tail)(f(init, head))(f)
      }
    }

    val num = foldLeft(file.map(wordcount))(0)(_ + _)

    println("wordcount:" + num)

  }
}
/*
* 这个例子是foldLeft的尾递归实现。foldLeft和reduceLeft相比更常用，多一个初始参数。

当用List做match case时。可以使用 :: 来解构。返回第一个元素head和剩余元素tail。

注：尾递归会在编译期优化，因此不用担心递归造成的栈溢出问题。
*
*
*
* */