import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf



/**
  * Created by wangziming on 5/31/16.
  */

/*
* TODO: Wrapper it as a function //the app job
* TODO: Should coming from different source
* TODO: Not only the normal way
* TODO: Exceptions
* TODO: Types
* TODO: Using RDD, MR, Cogroup
* TODO:  External Sort
* Desc : Judge if two data frames is equal
* Para : Two data frames, option 1 : sorted, option 2 : numerics  rounding
* Return : Boolean
* */


//Basic Code
object DataFrameComparatity{
  def main(args: Array[String]) {

    /*val logFile = "/Users/wangziming/Desktop/spark-1.5.2/README.md" // Should be some file on your system
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)

    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))*/

    val conf = new SparkConf().setAppName("DataFrame Equality Check")
    val sc = new SparkContext(conf)
    //Read two dataframes from json,
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    val df1 = sqlContext.read.json("/Users/wangziming/Desktop/spark-1.6.0-bin-hadoop2.6/examples/src/main/resources/people.json")
    val df2 = sqlContext.read.json("/Users/wangziming/Desktop/spark-1.6.0-bin-hadoop2.6/examples/src/main/resources/people.json")
    //Read column names from dataframes
    val df1_column = df1.columns
    val df2_column = df2.columns

    scala.util.Sorting.quickSort(df1_column)
    scala.util.Sorting.quickSort(df2_column)

    val length1 = df1_column.length
    val length2 = df2_column.length

    if(length1 != length2){
      println(false + "\tlength of attributes are not equal")
    }else{
      println(true + "\tlength of attributes are equal")
    }

    for(i <- 0 to length1 - 1){
      if(df1_column(i) != df1_column(i)){
        println(false)
      }else{
        println(true)
      }
    }
    //all thetypes

  }
}


  /*
  *  //Read two dataframes from json,
    val df1 = sqlContext.read.json("examples/src/main/resources/people.json")
    val df2 = sqlContext.read.json("examples/src/main/resources/people.json")
    //Read column names from dataframes
    val df1_column = df1.columns
    val df2_column = df2.columns

    scala.util.Sorting.quickSort(df1_column)
    scala.util.Sorting.quickSort(df2_column)

    val length1 = df1_column.length
    val length2 = df2_column.length

    if(length1 != length2){
      println(false + "\tlength of attributes are not equal")
    }else{
      println(true + "\tlength of attributes are equal")
    }

    for(i <- 0 to length1 - 1){
      if(df1_column(i) != df1_column(i)){
        println(false)
      }else{
        println(true)
      }
    }
    //all thetypes
  }
  *
  *
  *
  *
  * */


