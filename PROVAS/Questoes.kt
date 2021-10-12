fun main(){
//1)a1)
println("1-a1) pa(2,5,8) = ${pa(2,5,8)}")

//1)b1)
println("2-b1) fib(7) = ${fib(7)}")

val l1 = listOf(1,2,3)
println(convertListToLista(l1))
}

//1) Escreva uma função para gerar as seguintes sequencias de valores:
//Para cada uma dos ítens acima faça uma versão que retorne uma lista imutável da biblioteca de Kotlin e outra retornando uma classe de lista encadeada implementada por você

//a1) Uma progressão aritmética de valor inicial vo, razão r, e comprimento n (passados como argumentos)
fun pa(v0:Int, r:Int, n:Int):List<Int>{
  val l1 = (1..n).toList()
  val l2 = l1.map{x-> v0+((x-1)*(r))}
  return l2
}


//b1) A sequencia dos n primeiros números de fibonacci.
// fib(7) = [1,1,2,3,5,8,13]
fun fib(n:Int):List<Int>{
  val seq = generateSequence(Pair(0,1)) {p -> 
      Pair(p.second, p.first + p.second)
  } . map {p -> p.second}
  val aux = seq.take(n).toList()
  return aux
}


//2) Escreva uma função para converter uma lista imutável de kotlin em uma lista encadeada tradicional e outra para fazer a conversão inversa.
data class ListaFun(val info:Int, val prox:ListaFun?)
fun insereNoFim(v:Int, n:ListaFun?):ListaFun {
   if (n==null)
      return ListaFun(v,null)
   else
	  return ListaFun(n.info, insereNoFim(v,n.prox)) 
}
fun tamanho(l:ListaFun?):Int{
  if (l == null) return 0
  else return tamanho(l.prox) +1
}
fun nEzimo(num:Int,l:ListaFun?):Int{
  if(l!=null){
    if(num==0){
      return l.info
    }
    return nEzimo(num-1,l.prox)
  }
  return -1
}

fun convertListToLista(l2:List<Int>):ListaFun?{
  if()
}