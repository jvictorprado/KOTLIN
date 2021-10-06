fun main(){
  //val s = sequencia()
  // s.forEach{println(it)}
  val s2 = sequencia().iterator()
  val v1 = s2.next()
  println(v1)
  val v2 = s2.next()
  println(v2)
  val v3 = s2.next()
  println(v3)
  val v4 = s2.next()
  println(v4)


  val r1 = range(2,100)
  val r2 = r1.map{x -> 
    println("Elevando $x ao quadrado")
    x*x
  }

  val r3 = r2.filter{ x-> x % 2 == 0}
  val r4 = r3.take(10)
  for(i in r4){
    println(i)
  }
}

//ao contrario da lista, na sequencia cada elemento da coleção é calculado a medida que esse controle é requisitado
fun sequencia() = sequence{
  yield(1)
  yield(2)
  yield(3)
  yield(4)
}

fun range(st:Int, end:Int) = sequence{
  var atual = st
  while(atual<=end){
    println("Calculando o valor $atual da sequencia ")
    yield(atual)
    atual++
  }
}