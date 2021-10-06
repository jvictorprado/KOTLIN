fun main1(){
  println(quadruplo(2))
  println(q(2))
  println(quad(2))
}
//        REVISÃO

//        FUNÇÕES DE ALTA ORDEM
typealias Fun = (Int) -> Int

fun duasX(f:Fun):Fun = {x -> f(f(x))}
fun dobro(n:Int) = 2*n
fun quadruplo(n:Int) = 4*n

val q = duasX(::dobro) // = quadruplo

//--------
//        EXPRESSÕES LAMBDA
val dobro2 = {x:Int -> 2*x} //igual a fun dobro(n:Int) = 2*n
val quad = duasX(dobro2)
val quad2 = duasX({ x-> 2*x})
val quad3 = duasX{ x-> 2*x}

//--------
//        FUNÇÕES DE ALTA ORDEM E COLEÇÕES
// É possivel usar funções de alta ordem p manipular coleçõses de dados. ex: map, select, reduce(acumula). A API de Kotlin tem a implementação dessas e de varias outras primitivas:
fun main2(){
  val l1 = listOf(1,2,3,4,5,6)
  val l2 = l1.map{it*it}
  val l3 = l2.filter{it%2==0} //equivalente ao select
  val somal1 = l1.fold(0){soma, x -> x+soma}// fold = reduce
  val prodl1 = l1.fold(1){prod, x -> x*prod}
  print("l1 = ")
  l1.forEach{print("$it,")}
  println()
  println(somal1)
  println(prodl1)
  println("l2 = $l2")
  println("l3 = $l3")
  
  
  val teste1 = l3.all{it>3}//vê se todos elementos casam c o predicado
  val teste2 = l1.any{it==5}//vê se ao menos algum dos elementos casa com o predicado
  var teste3 = l2.count{it%4!=0}//vê quantos elementos casam com o predicado
  println(teste1)
  println(teste2)
  println(teste3)
}


//--------
//        NOVO ESTILO DE PROGRAMAÇÃO
//problema : somatorio dos numeros de A a B 
//solução 1: usando recursividade (funcional)
fun somatorio(a:Int, b:Int):Int{
  if(a>b) return 0
  return a+ somatorio(a+1,b)
}

//solução 2: usando funções de alta ordem(funcional)
fun somatorio2(a:Int, b:Int):Int{
  return (a..b).fold(0){s,x -> s+x}
}

// a..b é uma operação que define uma lista de valores
val range = 1..10
//vc pode fazer:
val range2 = (1..10).toList()
//mas kotlin n exige isso
//OBS: KOTLIN NÃO POSSUI UM FOR COMO O DE JAVA, POIS O DE JAVA É IMPERATIVO (UMA VAR QUE VAI SE ALTERANDO A CADA ITERAÇÃO). O FOR DE KOTLIN INTERAGE SOBRE OS ELEMENTOS DE UMA LISTA


//--------
//        ASPECTOS AVANÇADOS
class Contador(var v:Int){
  fun inc(n:Int):Int{
    v+=n
    println("inc")
    return v
  }
  fun dec(n:Int):Int{
    v-=n
    println("dec")
    return v
  }
}

//tipo metodo
typealias Metodo = Contador.(Int) -> Int
//podemos tbm usar metodos como se fossem funções. Assim os metodos da classe podem ser usados fora dela
typealias Funcao = (Int) -> Int

fun main(){
  val c1 = Contador(5)
  val c2 = Contador(4)
  var m1 : Metodo= Contador::inc
  c1.m1(2)
  println(c1.v)
  m1 = Contador::dec
  c1.m1(2)
  println(c1.v)

  //se quiser usar um metodo como se fosse uma função tem que dizer de que Contador(classe en questão) estou trabalhando
  val f1 : Funcao = c1::inc
  f1(2)// não precisa passar o objeto, pq f1 ja vai ser uma função especifica de c1

  //A diferença entre m1 e f1 é que no metodo m1 vc não diz quem é o objeto(assim, pode usar c1 em varios objetos) e a função f1 é delimitada p agir em um determinado objeto, logo o objeto n precisa ser passando já que f1 estará sempre se referindo a ele.

}


// lembrando:
//   c1.inc() - chamada/execução do metodo
//   c1::inc - receber/acessar o valor funcional(comportamento) do metodo, não executa-lo
// it - usado p representar um argumento implicito