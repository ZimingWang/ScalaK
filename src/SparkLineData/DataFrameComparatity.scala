import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

import org.apache.spark._
import org.apache.spark.sql._

import scala.math.BigDecimal
import scala.util.Sorting._
import java.util.ArrayList



/*
* This function is to test the equality of the content in two dataframes
* Para: Two data frames, option 1 : issorted, option 2 : rounding(rounded to two decimals/digits)
* Return: Boolean
*
* TODO: Exceptions
* TODO: External Sort
* TODO: Using RDD, MR, Cogroup
* */


object  DataFrameComparatity{

  def main(args: Array[String]){
    val conf = new SparkConf().setAppName("DataFrame Equality Check")
    val sc = new SparkContext(conf)
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)

    //Create the dataframe
    val address1 = "/Users/wangziming/Desktop/spark-1.6.0-bin-hadoop2.6/" +
      "examples/src/main/resources/people.json"
    val address2 = "/Users/wangziming/Desktop/spark-1.6.0-bin-hadoop2.6/" +
      "examples/src/main/resources/people1.json"

    val df1 = loadData(sqlContext,address1)
    val df2 = loadData(sqlContext,address2)
    println("Final ResultTT " + isDataFrameEqual(df1,df2,true,true))
    println("Final ResultTF" + isDataFrameEqual(df1,df2,true,false))
    println("Final ResultFF" + isDataFrameEqual(df1,df2,false,false))
    println("Final ResultFT" + isDataFrameEqual(df1,df2,false,true))
  }


  //For loading dataframe (For Expanding)
  def loadData(sqlContext : SQLContext,address : String): DataFrame ={
    //Read two dataframes from json
    val df = sqlContext.read.json(address)
    df
  }

  //Dataframe equality
  def isDataFrameEqual(df1 : DataFrame,
                       df2 : DataFrame,
                       Sorted : Boolean = false,
                       chooseRounding : Boolean = true): Boolean = {
    //Get the count of rows
    val df1_count = df1.count()
    val df2_count = df2.count()
    if(df1_count != df2_count){
        //println(df1_count + "\t" + df2_count)
        //println("The row count is not equal")
        return false
    }

    //Get the count of colunms
    val df1_column = df1.columns
    val df2_column = df2.columns
    //df1_column = quickSort(df1_column)
    //df2_column = quickSort(df2_column)
    val column1_length = df1_column.length
    val column2_length = df2_column.length
    if (column1_length != column2_length){
      //println(column1_length + "\t" + column2_length)
      //println("The column length is not equal")
      return false
    }
    /*for (i <- 0 to column1_length - 1){
      if(df1_column(i) != df1_column(i)){
        println(df1_column(i) + "\t" + df2_column(i))
        println("The column is not equal")
        return false
      }
    }*/
    /*var df1_list: ArrayList[Some] = null
    var df2_list: ArrayList[Some] = null
    //reassign the list
    if (isSorted) {
      df1_list = df1.collectAsList()
      df1_list = df2.collectAsList()
    }else {
      df1_list = df1.sort(df1_column(0)).collectAsList()
      df2_list = df2.sort(df2_column(0)).collectAsList()
    }*/

    var df1_list = df1.collectAsList()
    var df2_list = df2.collectAsList()
    if (!Sorted) {
      var df11 = df1.sort(df1_column(0))
      var df22 = df2.sort(df2_column(0))
      for (i <- 1 to column1_length - 1) {
        df11 = df11.sort(df1_column(i))
        df22 = df22.sort(df2_column(i))
      }
        df1_list = df11.collectAsList()
        df2_list = df22.collectAsList()
        //println("*********"+df1_list)
        //println("*********"+df2_list)
      }

    //Compare(Rounding into consideration)
    if(chooseRounding == false) {
      for (i <- 0 to df1_count.toInt - 1){
        for (j <- 0 to column1_length - 1){
          if(df1_list.get(i).get(j) !=
            df2_list.get(i).get(j)){
            //println(df1_list.get(i).get(j) + "\t" + df2_list.get(i).get(j))
            //println("The row content is not equal")
            return false
          }
        }
      }
    }else{
      for (i <- 0 to df1_count.toInt - 1){
        for (j <- 0 to column1_length - 1){
          if (df1_list.get(i).get(j) == null ||
              df2_list.get(i).get(j) == null){
            if (df1_list.get(i).get(j) !=
                df2_list.get(i).get(j)){
                //println(df1_list.get(i).get(j) + "\t" + df2_list.get(i).get(j))
                //println("The row content is not equal null")
                return false
            }
          }else{
            var raw1 = (df1_list.get(i).get(j)).toString
            var raw2 = (df2_list.get(i).get(j)).toString
            if (raw1.endsWith("f") || raw1.endsWith("F")){
              raw1 = raw1.substring(0, raw1.length - 1)
            }
            if (raw2.endsWith("f") || raw2.endsWith("F")){
              raw2 = raw2.substring(0, raw2.length - 1)
            }
            try {
              val res1 = BigDecimal(raw1)
                .setScale(2, BigDecimal.RoundingMode.HALF_UP)
                .toDouble
              val res2 = BigDecimal(raw2)
                .setScale(2, BigDecimal.RoundingMode.HALF_UP)
                .toDouble
              if(res1 != res2){
                //println(res1 + "\t" + res2)
                //println("The rouding row content is not equal null")
                return false
              }
            }catch{
              case ex: Exception => {
                if(raw1 != raw2){
                  //println(raw1 + "\t" + raw2)
                  //println("The rouding exce row content is not equal null")
                  return false
                }
              }
            }
          }
        }
      }
    }
        return true
  }
}



