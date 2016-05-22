/**
  * Created by wangziming on 5/22/16.
  */
import akka.actor.{ Actor, ActorSystem, Props
/*import akka.actor.{ Actor, ActorSystem, Props }

val system = ActorSystem()

class EchoServer extends Actor {
  def receive = {
    case msg: String => println("echo " + msg)
  }
}

val echoServer = system.actorOf(Props[EchoServer])
echoServer ! "hi"

system.shutdown*/


/*Actor是Scala的并发模型。在2.10之后的版本中，使用Akka作为其推荐Actor实现。

Actor是类似线程的实体，有一个邮箱。 Actor可以通过system.actorOf来创建,receive获取邮箱消息，！向邮箱发送消息。

这个例子是一个EchoServer，接受信息并打印。*/
