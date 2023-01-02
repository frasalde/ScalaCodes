
object Cells {
  val fieldsToJoin: Array[Column] = Array(col("key_1"), col("key_2"),col("key_3"), col("key_4"))
  
  val (front: Array[Column], back: Array[Column]) = fieldsToJoin.splitAt(fieldsToJoin.length/2)
  
  val condition: Column =
  if(fieldsToJoin.size > 1) {
   front.zip(back).map { case (e1, e2) => e1 === e2 }.reduce(_ and _)
  }
  else null

  /* ... new cell ... */
}
                  