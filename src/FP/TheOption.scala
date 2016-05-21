package FP

/**
  * Created by wangziming on 5/21/16.
  */
object TheOption {

  def main(ar : Array[String]): Unit ={
    def getProperty(name: String): Option[String] = {
      val value = System.getProperty(name)
      if (value != null) Some(value) else None
    }

    val osName = getProperty("os.name")

    val osName1= None
    osName match {
      case Some(value) => println(value)
      case _ => println("none")
    }

    println(osName1.getOrElse("none"))

    osName.foreach(print _)
  }

}

/*
*
* Scala提供了Option机制来解决，代码中不断检查null的问题。

这个例子包装了getProperty方法，使其返回一个Option。 这样就可以不再漫无目的地null检查。只要Option类型的值即可。

使用pattern match来检查是常见做法。也可以使用getOrElse来提供当为None时的默认值。

给力的是Option还可以看作是最大长度为1的List，List的强大功能都可以使用。

再见 NullException
*
*
* */
