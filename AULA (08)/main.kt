fun main() {
  arrays()
  listas()
}

//GENERICS
class Node<C>(val info:C, val prox:Node<C>?)

fun <C,D> primeiro(a:C, b:D) = a

//COLEÇÕES

//ARRAYS. EM KOTLIN VOCÊ TEM QUE DIZER O VALOR DOS ELEMENTOS DO ARRAY QUANDO CRIAR O ARRAY

// HÁ VAR CONSTANTES OU ALTERAVEIS E HÁ
// ESTRUTURAS CONSTANTES OU ALTERAVEIS

//NO EXEMPLO ABAIXO, O ARR É UMA VARIAVEL CONSTANTE QUE É REFERENCIA P ONDE UM ARRAY ESTÁ LOCALIZADO. ENTÃO QUANDO FAZEMOS arr[2] = 8 QUEM ESTÁ SENDO MODIFICADO É A ESTRUTURA(ARRAY) REFERENCIA

fun arrays(){
  val arr : Array<Int> = arrayOf(1,2,3)
  // arr = arrayOf(2,3)
  println("tamanho arr = ${arr.size}")
  println(arr)
  println("arr[2] = ${arr[2]}")
  //modifica a estrutura mas não a variavel
  arr[2] = 8
  println(arr)
  println("arr[2] = ${arr[2]}")
}

/* Coleções na Biblioteca 
       Coleções Funcionais (Não são alteráveis)
	   Coleções Imperativas (Podem ser modificadas)
   Tipos
       Listas
	   Conjuntos
	   Mapeamentos 
*/

/* Listas: 
Coleções de Elementos que podem se repetir e a ordem dos elementos é importante. Bastante parecida com Vector
*/

fun listas(){
  // Listas são parecidos ao Vector em Java 
	// mas não podem ser modificadas
  val l : List<Int> = listOf(1,2,3)
  println("tamanho l = ${l.size}")
  println("l[2] = ${l[2]}")
  println(l)
  // daria erro >>  l[2] = 8

/* Listas Mutavéis são listas que podem ser modificadas 
	   inclusive ter elementos inseridos ou removidos equivalente
	   exatamente a classe Vector de Java
	*/
  val ml : MutableList<Int> = mutableListOf(1,2,3)
  println("tamanho ml = ${ml.size}")
  println("ml[2] = ${ml[2]}")
  println(l)
  ml[2] = 8
  ml.add(5)
  println(ml)
  ml.removeAt(2)
  println(ml)
  ml.remove(5)
  println(ml)
}


// ARRAY = ESTRUTURA VARIAVEL
// LIST = ESTRUTURA CONSTANTE 