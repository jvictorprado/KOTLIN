fun main() {
  val f :(Float)->Float = {x:Float -> x +3}   
  println(somatorio(f,1f,10f,2f))
  println(somatorio2(f,1f,10f,2f))
}

fun somatorio(f:(Float)->Float,inicio:Float,fim:Float,inc:Float):Float{
  if(inicio<=fim){
    return f(inicio) + somatorio(f,inicio+inc,fim,inc)
  }
  return 0f
}

// fun somatorio2(f:(Float)->Float, inicio:Float,fim:Float,inc:Float):Float{
//   val aux= ((inicio+fim)%inc)/inc
//   val aux2 = if(aux>0.5)(1-aux)+((inicio+fim)/inc) else ((inicio+fim)/inc) - aux
//   val aux3 = aux2.toInt()
  
//   val l = generateSequence(f(inicio)){x -> x+inc}
//   val l2 = l.take(aux3).toList()
//   val soma = l2.fold(0f){soma:Float, x-> x+soma}
//   return soma
// }


