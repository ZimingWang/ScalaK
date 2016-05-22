/**
  * Created by wangziming on 5/22/16.
  */

class Person(val name: String) {
  override def equals(other: Any) = other match {
    case that: Person => name.equals(that.name)
    case _ => false
  }
}


object TheEqual{
  def main(ar : Array[String]): Unit ={
    println(new Person("Black") == new Person("Black"))
  }
}
