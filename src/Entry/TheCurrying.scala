package Entry

/**
  * Created by wangziming on 5/21/16.
  */

/*
* scala 中没有 static 关键字

所以 对于一个class来说，所有的方法和成员变量在实例被 new 出来之前都是无法访问的

so ...... class文件中的main方法也就没什么用了

scala object 中所有成员变量和方法默认都是 static 的

so ...... 可以直接访问main方法
* */
object TheCurrying {


  def withClose(closeAble: { def close(): Unit })
               (op: { def close(): Unit } => Unit) {
    try {
      op(closeAble)
    } finally {
      closeAble.close()
    }
  }

  class Connection {
    def close() = println("close Connection")
  }
  def main(argv : Array[String]): Unit ={
    val conn: Connection = new Connection()
    withClose(conn)(conn =>
      println("do something with Connection"))
  }


}


