/**
  * Created by wangziming on 5/22/16.
  */

/*import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._
import java.util.Date

case class Twitter(id: Long, text: String, publishedAt: Option[java.util.Date])

var twitters = Twitter(1, "hello scala", Some(new Date())) ::
  Twitter(2, "I like scala tour", None) :: Nil

var json = ("twitters"
  -> twitters.map(
  t => ("id" -> t.id)
    ~ ("text" -> t.text)
    ~ ("published_at" -> t.publishedAt.toString())))

println(pretty(render(json)))*/


/*
* DSL是Scala最强大武器，可以使一些描述性代码变得极为简单。

这个例子是使用DSL生成JSON。Scala很多看似是语言级的特性也是用DSL做到的。

自己编写DSL有点复杂，但使用起来非常方便。
*
*
*
* */
