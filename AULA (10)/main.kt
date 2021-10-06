fun main(){
  teste2()
}
// Linguagens Imperativas Tradicionais possuem funções de 2ª classe
// -Declarações de funções tem uso limitado
// -Justificativa : Performance, Tecnologia de compiladores, etc

//                   ### Funções de primeira classe ###
// Podem ser usadas da mesma maneira que outros valores primitivos:
// ● Funções Locais
// ● Tipo Função
// ● Declarar variáveis e constantes
// ● Comandos de atribuição
// ● Funções como argumentos
// ● Funções que retornam funções


//            FUNÇÕES LOCAIS
//Funções podem ser locais a outras funções como as variáveis não funcionais

fun f(n:Int) = n+1  //f global
var var1 = 6  //variavel global
val val1 = 8  //valor global

fun teste(){
  fun f(n:Int) = n*2 //f local
  var var1 = 1 //variavel local
  val val1 = 2 // valor global
}
//-------------------------------------------------------------------

//           TIPO/VARIÁVEIS E VALORES
fun sucessor(n:Int) = n+1
fun dobro(n:Int) = n*2

fun teste2(){
  // Tipo : (Int)-> Int indica uma função com um argumento Int e um retorno Int
  //f é declarada como uma variável função 
  // ::sucessor retorna o valor da função
  var f : (Int) -> Int = ::sucessor 
  //pode ser chamada como funções normais
  println(f(3))
  //pode ser modificada se não for "val"
  f = ::dobro
  var g = ::dobro
  println(g(3))
  println(f(3))
}
//-----------------------------------------------------------------

//          EXPRESSÕES λ (LAMBDA)
//Notação usada para definir valores-função (anonimas)
fun testes3(){
  val f : (Int) -> Int = {x : Int -> 2*x + 1}
      //equivalente a:
  fun f2(x:Int) = 2*x + 1
  //usando inferencia de tipos podemos escrever a mesma declaração como:
  val f3 = {x : Int -> 2*x + 1} //1º
  val f4 : (Int) -> Int = {x -> 2*x + 1} //2º
  val f5 : (Int) -> Int = {2*it + 1} //3º

  //usando typealias
  fun sucessor(n:Int) = n+1
  val g1 : IFun = ::sucessor
  val g2 : IFun = {x-> x+1}
}
typealias IFun = (Int) -> Int