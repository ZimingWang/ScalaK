/**
  * Created by wangziming on 5/31/16.
  */

/*
* TODO: Wrapper it as a function
* TODO: Should coming from different source
* TODO: Not only the normal way
* TODO: Exceptions
* TODO: Types
* Desc : Judge if two data frames is equal
* Para : Two data frames, option 1 : sorted, option 2 : numerics  rounding
* Return : Boolean
* */


//Basic Code


//Read two dataframes from json,
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


//all the types
