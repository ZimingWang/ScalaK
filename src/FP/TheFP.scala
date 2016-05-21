/**
  * Created by wangziming on 5/21/16.
  */



//Code Simplicity

object TheFP{
  val list = List(1, 2, 3, 4)

  def containsOdd(list: List[Int]): Boolean = {
    for (i <- list) {
      if (i % 2 == 1)
        return true;
    }
    return false;
  }



  def main(argv : Array[String]): Unit ={

    println("list contains Odd ? " + containsOdd(list))
    println("list contains Odd ? " + list.exists(((x : Int) => x % 2 == 0)))
    println("list contains Odd ? " + list.exists(_ % 2 == 0))

  }


}


