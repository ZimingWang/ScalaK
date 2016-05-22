/*import akka.actor.{ Actor, Props, ActorSystem }
import akka.testkit.CallingThreadDispatcher

implicit val system = ActorSystem()

class EchoServer(name: String) extends Actor {
  def receive = {
    case msg => println("server" + name + " echo " + msg +
      " by " + Thread.currentThread().getName())
  }
}

val echoServers = (1 to 10).map(x =>
  system.actorOf(Props(new EchoServer(x.toString))
    .withDispatcher(CallingThreadDispatcher.Id)))
(1 to 10).foreach(msg =>
  echoServers(scala.util.Random.nextInt(10)) ! msg.toString)

system.shutdown*/


/*
* Actor比线程轻量。在Scala中可以创建数以百万级的Actor。奥秘在于Actor直接可以复用线程。

Actor和线程是不同的抽象，他们的对应关系是由Dispatcher决定的。

这个例子创建4个Actor，每次调用的时候打印自身线程名称。

可以发现Actor和线程之间没有一对一的对应关系。一个Actor可以使用多个线程，一个线程也会被多个Actor复用。
*
* */
