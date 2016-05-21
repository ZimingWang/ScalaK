package Entry

/**
  * Created by wangziming on 5/21/16.
  */

/*
Syntatic Candy
https://www.zhihu.com/question/30097211/answer/46785556

 // 没使用语法糖的 sum 函数
   def sum(f: Int => Int): (Int, Int): Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0 else f(a) + sumF(a + 1, b)

    sumF
  }
  // 使用语法糖后的 sum 函数
   def sum(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f)(a + 1, b)

作者：叶少么么哒
链接：https://www.zhihu.com/question/20037482/answer/89060328
来源：知乎
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
简单来说，编程中提到的 lambda 表达式，通常是在需要一个函数，但是又不想费神去命名一个函数的场合下使用，也就是指匿名函数。这一用法跟所谓 λ 演算（题目说明里的维基链接）的关系，有点像原子弹和质能方程的关系，差别其实还是挺大的。

不谈形式化的 λ 演算，只说有实际用途的匿名函数。先举一个普通的 Python 例子：将一个 list 里的每个元素都平方：
map( lambda x: x*x, [y for y in range(10)] )

作者：涛吴
链接：https://www.zhihu.com/question/20125256/answer/14058285
来源：知乎
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
* scala 中没有 static 关键字

所以 对于一个class来说，所有的方法和成员变量在实例被 new 出来之前都是无法访问的

so ...... class文件中的main方法也就没什么用了

scala object 中所有成员变量和方法默认都是 static 的

so ...... 可以直接访问main方法
* */
object TheCurrying {


  def withClose(closeAble: { def close(): Unit })
               (op: { def close(): Unit } => Unit) {
    try {
      op(closeAble)
    } finally {
      closeAble.close()
    }
  }

  class Connection {
    def close() = println("close Connection")
  }
  def main(argv : Array[String]): Unit ={
    val conn: Connection = new Connection()
    withClose(conn)(conn =>
      println("do something with Connection"))
  }


}


