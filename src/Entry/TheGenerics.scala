/**
  * Created by wangziming on 5/21/16.
  */

//http://herbix.me/archives/scala%E5%AD%A6%E4%B9%A0%EF%BC%88%E4%BA%94%EF%BC%89-%E6%B3%9B%E5%9E%8B



object TheGenerics{

  def main(argv : Array[String]): Unit ={
    val conn: Connection = new Connection()
    val msg = withClose(conn) { conn => {
      println("do something with Connection")
      "123456"// 123456
    }
    }

    println(msg)
  }

  def withClose  [A <: { def close(): Unit }, B]   (closeAble: A)
                                              (f: A => B)    :      B =
    try {
      f(closeAble)
    } finally {
      closeAble.close()
    }
}

