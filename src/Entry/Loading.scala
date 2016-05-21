import java.util.Scanner
import scala.reflect.io.File
/**
  * Created by wangziming on 5/20/16.
  */

object Loading{

  def main(argv : Array[String]): Unit = {

    withScanner(File("/Users/wangziming/LearnScala/README.md"),
      scanner => println("pid is " + scanner.next()))
  }


  /*IMFAO
  * using the op function to wrap the scanner
  * and Unit(void could be using as a println output)
  *
  *
  * */
  def withScanner(f: File, op: Scanner => Unit) = {
    val scanner = new Scanner(f.bufferedReader)
    try {
      op(scanner)
    } finally {
      scanner.close()
    }
  }
}