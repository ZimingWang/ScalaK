/**
  * Created by wangziming on 5/21/16.
  */

class PatternMM{

  def fibonacci(in: Any) : Int = in match {
    case 0 => 0
    case 1 => 1
    case n: Int if(n > 1) => fibonacci(n - 1) + fibonacci(n - 2)
    case n: String => fibonacci(n.toInt)
    case _ => 0
  }
}


object PatternM{
  def main(argv : Array[String]): Unit ={

    val patternMM = new PatternMM()
    println(patternMM.fibonacci(3))
    println(patternMM.fibonacci(-3))
    println(patternMM.fibonacci("3"))


  }
}






