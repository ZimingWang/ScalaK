/**
  * Created by wangziming on 5/21/16.
  */

trait ForEachAble[A] {//generics
  def iterator: java.util.Iterator[A]
  def foreach(f: A => Unit) = {//functions
    val iter = iterator
    while (iter.hasNext)
      f(iter.next)
  }
}

trait JsonAble {
  def toJson() = {

  }
    //scala.util.parsing.json.JSONFormat.defaultFormatter(this)//being removed

}


object TheTraits {

  def main(argv : Array[String]): Unit ={
    val list = new java.util.ArrayList[Int]() with ForEachAble[Int] with JsonAble
    list.add(1); list.add(2)

    println("For each: "); list.foreach(x => println(x))
    println("Json: " + list.toJson())

  }

}
