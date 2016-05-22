/**
  * Created by wangziming on 5/22/16.
  */

import java.text.SimpleDateFormat


//这个例子可以将String自动转换为Date类型。隐式转换时实现DSL的重要工具。

object TheImplicity{

  def main(ar : Array[String]): Unit ={
    implicit def strToDate(str: String) =
      new SimpleDateFormat("yyyy-MM-dd").parse(str)
    println("2013-01-01 unix time: " + "2013-01-01".getTime()/1000l)
  }
}

