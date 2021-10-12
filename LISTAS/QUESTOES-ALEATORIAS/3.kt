fun main(){
  somatorio2(1,10,3)
}

fun somatorio2(inicio:Int,fim:Int,inc:Int){
  val aux= ((inicio+fim)%inc)/inc
  val aux2 = if(aux>0.5)(1-aux)+((inicio+fim)/inc) else ((inicio+fim)/inc) - aux
  
  val l = generateSequence(inicio){x -> x+inc}
  val l2 = l.take(aux2).toList()
  val l3 = l2.fold(0){soma:Int, x-> x+soma}
  println(l2)
  println(l3)
}

fun somatorio2(f:(Float)->Float, inicio:Float,fim:Float,inc:Float){
  val aux= ((inicio+fim)%inc)/inc
  val aux2 = if(aux>0.5)(1-aux)+((inicio+fim)/inc) else ((inicio+fim)/inc) - aux
  val aux3 = aux2.toInt()
  
  val l = generateSequence(inicio){x -> x+inc}
  val l2 = l.take(aux3).toList()
  val l3 = l2.fold(0f){soma:Float, x-> x+soma}
  println(l3)
}
