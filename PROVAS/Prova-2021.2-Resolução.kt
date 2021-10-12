data class ListaEncadeada(val n:Int, val prox:ListaEncadeada?)

fun main() {

  // LETRA A
  println("2) A) :")
  val la1 = listOf(1,5,6,8)
  val la2 = listToEncadeada(la1)
  println("""
  Lista de Kotlin: $la1
  Transformada em uma Lista encadeada : $la2 
  """)

  //LETRA B
  println("2) B) :")
  val lb1 = ListaEncadeada(8,ListaEncadeada(5,ListaEncadeada(2,ListaEncadeada(4,null))))
  val lb2 = encadeadaToList(lb1) 
  println("""
  Lista encadeada : $lb1
  Transformada em uma Lista de Kotlin : $lb2
  """)

  //LETRA C
  println("2) C) :")
  val lc1 = ListaEncadeada(60,ListaEncadeada(60,ListaEncadeada(20,ListaEncadeada(13,ListaEncadeada(42,ListaEncadeada(42,null)))))) 
  val lc2 = compactar(lc1)
  println("""
  Lista encadeada : $lc1
  Lista encadeada compactada : $lc2
  """)

  //LETRA D
  println("2) D) :")
  val ld1 = ListaEncadeada(80,ListaEncadeada(51,ListaEncadeada(12,ListaEncadeada(4,null))))
  val ld2 = removerenesimo(1,ld1)
  println("""
  Lista encadeada : $ld1

  Nova Lista depois de remover o elemento solicitado : $ld2
  """)

}




// 2) LETRA A
fun listToEncadeada(l1:List<Int>):ListaEncadeada?{
  val le : ListaEncadeada? = ListaEncadeada(0,null)
  var le2 = le
  for(i in 0..((l1.size)-1)){
    le2 = insereNoFim(l1[i],le2)
  }
  val le3 = removerenesimo(0,le2)
  return le3
}


// 2) LETRA B
fun encadeadaToList(le:ListaEncadeada?):List<Int>{
  val l1 = 1..tamanho(le)
  val l2 = (l1.map{x-> nEzimo(x-1,le)}).toList()
  return l2;
}

fun compactar(le:ListaEncadeada?):ListaEncadeada?{
  val l1 = encadeadaToList(le)
  val l2 = (l1.toSet()).toList()
  val l3 = listToEncadeada(l2)
  return l3
}


// 2) LETRA D
fun removerenesimo(pos:Int, l1:ListaEncadeada?):ListaEncadeada? =
  if ( l1 == null ) null
  else if ( pos==0 ) l1.prox
  else ListaEncadeada(l1.n,removerenesimo(pos-1,l1.prox))




// FUNÇÕES AUXILIARES:
fun tamanho(l:ListaEncadeada?):Int{
  if (l == null) return 0
  else return tamanho(l.prox) +1
}

fun nEzimo(num:Int,l:ListaEncadeada?):Int{
  if(l!=null){
    if(num==0){
      return l.n
    }
    return nEzimo(num-1,l.prox)
  }
  return -1
}

fun insereNoFim(v:Int, le:ListaEncadeada?):ListaEncadeada? {
   if (le==null)
      return ListaEncadeada(v,null)
   else
	  return ListaEncadeada(le.n, insereNoFim(v,le.prox)) 
}
