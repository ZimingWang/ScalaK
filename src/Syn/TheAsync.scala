package Syn

/**
  * Created by wangziming on 5/22/16.
  */

import akka.actor.ActorDSL._
import akka.pattern.ask



object TheAsync{

  def main(ar : Array[String]): Unit ={
    implicit val ec = scala.concurrent.ExecutionContext.Implicits.global
    implicit val system = akka.actor.ActorSystem()

    val versionUrl = "https://raw.github.com/scala/scala/master/starr.number"

    val fromURL = actor(new Act {
      become {
        case url: String => sender ! scala.io.Source.fromURL(url)
          .getLines().mkString("\n")
      }
    })

    val version = fromURL.ask(versionUrl)(akka.util.Timeout(5 * 1000))
    version onComplete {
      case msg => println(msg); system.shutdown
    }
  }

}

/*
*http://stackoverflow.com/questions/29339005/run-main-0-java-lang-nosuchmethoderror-scala-collection-immutable-hashset-emp
* 异步操作可以最大发挥效能。Scala的Futrue很强大，可以异步返回。

可以实现Futrue的onComplete方法。当Futrue结束的时候就会回调。

在调用ask的时候，可以设定超时。
* */