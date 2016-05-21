/**
  * Created by wangziming on 5/21/16.
  */


class Connection {
  def close() = println("close Connection")
}

object TheDuck{

  def main(agrv : Array[String]): Unit ={
    val conn = new Connection()
    withClose(conn, conn =>
      println("do something with Connection"))//conn could be the para because it has the close function


    def withClose(closeAble: { def close(): Unit },//var a function
                  op: { def close(): Unit } => Unit) {//
      try {
        op(closeAble)//closable could be the para because it has the close function
      }finally {
        closeAble.close()
      }
    }
  }

}

