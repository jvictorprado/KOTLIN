fun main(){
  println("a) PA(1,4,6) = ${pa(1,4,6)}")
  
  val lista = (2..100).toList()
  println("b)A soma de todos os valores primos entre 2 e 100 é = ${somaPrimos(lista)}")

  fibo(6)

  
}

// a) Listar uma progressão aritmética a partir do seu valor inicial, razão de número de elementos
fun pa(v0:Int, r:Int, n:Int):String{
  val l1 = (1..n).toList()
  val l2 = l1.map{x-> v0+((x-1)*(r))}
  return "${l2.toString()}"
}

// b) Soma de todos os valores primos entre 2 e 100
fun somaPrimos(l:List<Int>):Int{
  val listaPrimos =l.filter{x: Int -> x>2 && x<100 && primo(x)}  
  val soma = listaPrimos.fold(0){soma: Int, x -> x+soma}
  return soma
}

fun primo(n:Int):Boolean{ 
  val aux = (2..n-1).toList()
  val aux2 = aux.filter{x:Int -> n%x==0}
  if(aux2.size==0){
    return true
  }
  return false
}

// c) Imprimir os n-primeiros números de uma série de fibonacci

fun fibo(n:Int){
  val seq = generateSequence(Pair(0,1)) {p -> 
      Pair(p.second, p.first + p.second)
  } . map {p -> p.second}
  val aux = seq.take(n).toList()
  println("c) Os $n primeiros elementos da série de fibonacci = $aux")
  // val aux = (1..n).toMutableList()
  // aux.forEachIndexed { pos, valor -> 
  //     if (pos<2)
	//      aux[pos] = 1
	//   else 
	//      aux[pos] = aux[pos-1] + aux[pos-2]
  // }

  // println("resultado = $aux")

}

fun testeArray() {
	val a1 = arrayOf(
   	    arrayOf(1,2,3,4),
		arrayOf(2,3,4,5),
		arrayOf(3,4,5,6)
	)
	val a2 = intArrayOf(1,2,3,4)
	val a3 = arrayOf(1,2,3,4)
	println("a1 = \n$a1")
	println("a2 = \n$a2")
	println("a3 = \n$a3")

	val l1 = listOf(1,2,3)
	println("l1 = $l1")
	println("l1+1 = ${l1 + 1}")
	println("1+l1 = ${listOf(1) + l1}")
	val l2 = List(3) {x -> x * x + 1}
	println("l2 = $l2")
}

// d) Imprimir as n-primeiras linhas do triângulo de pascal

// proxLinha(listOf(1)) = listOf(1,1)
// proxLinha(listOf(1,1)) = listOf(1,2,1)
// proxLinha(listOf(1,2,1)) = listOf(1,3,3,1)
// proxLinha(listOf(1,3,3,1)) = listOf(1,4,6,4,1)
// ...

fun proxLinha(l0:List<Int>):List<Int> {
  return listOf()
}