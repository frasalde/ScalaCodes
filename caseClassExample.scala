
object Cells {
  import org.apache.spark.sql.hive.HiveContext
  import org.apache.spark.sql._
  import org.apache.spark.sql.functions._
  import scala.annotation.tailrec
  
  val sc = sparkContext
  val sqlContext = new org.apache.spark.sql.SQLContext(sc)
  import sqlContext.implicits._
  
    val customersDF = sc.parallelize(Seq(
      ("Francisco", "Salvado", "frasalde@gmail.com", "001"),
      ("Martin","Odersky", "god@god.com", "002")
    )).toDF("firstname", "lastname", "email", "customerid")
  
    case class Customers(firstname: String, lastname: String, email: String, customerid: String)
  
    val customers: List[Customers] = customersDF.collect.map(r => Customers(
      r.getAs[String]("firstname"),
      r.getAs[String]("lastname"),
      r.getAs[String]("email"),
      r.getAs[String]("customerid")
    )).toList

  /* ... new cell ... */
}
                  