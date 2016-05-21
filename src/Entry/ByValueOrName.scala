/**
  * Created by wangziming on 5/21/16.
  */

object ByValueOrName{

  val excutable = false

  def main(argv : Array[String]): Unit ={
       val input = "Only String"
       println(Recieved(input))
       println(Recieved2(input + 1 / 0))
  }


  def Recieved(para : String):String = {
       para
  }

  def Recieved2(para : =>String):String = {
    var a = "NONE"
    if(excutable)
      a = para
    return a
  }
}