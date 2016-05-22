/**
  * Created by wangziming on 5/22/16.
  */
import scala.util.matching.Regex

object Email{

  def unapply(str: String) =  new Regex("""(.*)@(.*)""")
    .unapplySeq(str).get match{
    case user :: domain :: Nil => Some(user, domain)
    case _ => None
  }//多行字符串用三个双引号来表示分隔符，格式为：""" ... """

  def main(ar : Array[String]): Unit ={
    "user@domain.com"  match {
      case Email(user,domain) => println(user + "@" +domain)

    }
}

}
