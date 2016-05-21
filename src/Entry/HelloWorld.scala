import sun.jvm.hotspot.HelloWorld

/**
  * Created by wangziming on 5/20/16.
  */

object HelloWorld{

  def main(args : Array[String]): Unit ={
      println("Hello Scala")
  }

}


object Point1{

  def main(argv : Array[String]): Unit ={
      val a = "a"
      var b = "b"
      // a = "c";//error, val can not be changed

      println(args1(1));//output:  ()
      println(args2(2));
      println(return1(2));
      println(return2(2));

      println(funcAsPara(return2,2)) //put the name of function : reference ?

  }

  //scala generics http://herbix.me/archives/scala%E5%AD%A6%E4%B9%A0%EF%BC%88%E4%BA%94%EF%BC%89-%E6%B3%9B%E5%9E%8B
  def args1( a: Int ){//Int , not int

  }

  def args2(a: Int) = a * a

  def return1(a: Int) = {
     a * a //defaulted return
    // return a * a
  }

  def return2(a: Int) : Int = {
    //a * a //defaulted return
    return a * a ;//optional
  }

  def funcAsPara(f:Int => Int , arg : Int) = f(arg) + arg

}
