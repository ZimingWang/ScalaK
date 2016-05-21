/**
  * Created by wangziming on 5/21/16.
  */

class Persion(val firstName : String, val lastName : String){
  private var _age = 0;
  def age = _age
  //def age_ = (newAge: Int) = _age = newAge
  def age_=(newAge: Int) = _age = newAge
  def fullName() = firstName + " " + lastName;

  override def toString() = fullName()//or it will output the address

}

object TheClass{
  def main(argv : Array[String]): Unit ={
    val obama: Persion = new Persion("Barack", "Obama")
    println("Persion: " + obama)
    println("firstName: " + obama.firstName)
    println("lastName: " + obama.lastName)
    obama.age_=(51)
    obama.age = 51
    println("age: " + obama.age)

  }
}
