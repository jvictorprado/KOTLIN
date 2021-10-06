//        AVALIAÇÃO TARDIA(LAZY)
// - UMA VARIAVEL SÓ É CALCULADA NO MOMENTO EM QUE ELA É NECESSÁRIA
// - OS ELEMENTOS DE UMA LISTA SÃO CALCULADOS A MEDIDA QUE SÃO NECESSÁRIOS
// - FUNÇÕES PODEM RETORNAR DADOS PARCIALMENTE CALCULADOS

// Obs: Como é a implementação da função run :
// fun run (f : () - > A) : A {
//   return f()
// }
// Obs: As variaveis globais são criadas antes do main ser executado




// EXEMPLO SEM AVALIAÇÃO TARDIA:

// val a = run {
//   println("Calculando o valor de A")
//   3
// }
// val b = run {
//   println("Calculando o valor de B")
//   4
// }
// val c = run {
//   println("Calculando o valor de C")
//   5
// }

// fun main(){
//   println("B = $b")
//   println("A = $a")
// }

// Vai rodar o seguinte : 
// Calculando o valor de A
// Calculando o valor de B
// Calculando o valor de C
// B = 4
// A = 3

// ou seja, A foi calculada antes de b, mesmo não sendo requisitada primeiro. E C foi calculada mesmo sem ser usada



//COM AVALIAÇÃO TARDIA
val a by lazy {
  println("Calculando o valor de A")
  3
}

val b by lazy{
  println("Calculando o valor de B")
  4
}

val c by lazy{
  println("Calculando o valor de C")
  5
}
//qual a diferença entre definir "a" como lazy e definir como uma função? :
fun fa():Int{
  println("Calculando o valor de A como função")
  return 3
}
// a diferença é que, como lazy, uma vez calculado o valor da variavel não precisamos calcular novamente. Diferende do caso da função

fun main2(){
  println("B = $b")
  println("A = $a")
  println("fa() = ${fa()}")
  println("A = $a")
  println("fa() = ${fa()}")
  
  println("I = $i")
  println("J = $j")
}


// obs: essa tecnica funciona melhor em linguagens funcionais do que imperativas, pq o uso de variaveis(var) e valiação lazy pode ser perigoso, ex: 
// println("J = $j")
// println("I = $i")
// da retornos diferentes de 
// println("I = $i")
// println("J = $j")


var x = 10
val i by lazy {
  println("Calculando o valor de I")
  x++
  3+x
}

val j by lazy{
  println("Calculando o valor de J")
  x*=2
  4+x
}

val k by lazy{
  println("Calculando o valor de K")
  x = x/2
  5+x
}





//        AVALIAÇÃO TARDIA COM COLEÇÕES

fun main(){
  //val seq = sequenceOf(1,2,3,4)
  // sequence é parecido com list, com a diferença que : todos os elementos da sequencia são calculados de maneira tardia(lazy)
  val x = sequenceOf(1,2,3,4) // p ver a diferença entre sequence e list, troca o listOf <-> sequenceOf

  // seq.forEach{
  //   println("elem de seq: $it")
  // }
  // println()
  x.forEach{
    println("elem de x: $it")
  }
  println()
  
  //todos os elementos serão calculados no momento em que a lista for definida, pois listas são inerentemente eager(tradicional).
  val x2 = x.map{
    println("map de $it em x2")
    2*it
  }

  x2.forEach{
    println("elem de x2: $it")
  }
}