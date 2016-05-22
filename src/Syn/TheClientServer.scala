/**
  * Created by wangziming on 5/22/16.
  */

import akka.actor.{ Actor, ActorSystem, Props }
import com.typesafe.config.ConfigFactory



object TheClientServer{
  def main(ar : Array[String]): Unit = {
    implicit val system = akka.actor.ActorSystem("RemoteSystem",
      ConfigFactory.load.getConfig("remote"))
    class EchoServer extends Actor {
      def receive = {
        case msg: String => println("echo " + msg)
      }
    }

    val server = system.actorOf(Props[EchoServer], name = "echoServer")

    val echoClient = system
      .actorFor("akka://RemoteSystem@127.0.0.1:2552/user/echoServer")
    echoClient ! "Hi Remote"

    system.shutdown

  }


}
/*
* Actor是并发模型，也使用于分布式。

这个例子创建一个Echo服务器，通过actorOf来注册自己。

然后再创建一个client，通过akka url来寻址。

除了是通过url创建的，其他使用的方法和普通Actor一样。
*
*
* */