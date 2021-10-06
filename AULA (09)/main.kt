fun main() {
  conjuntos()
  println("-----------")
  mapeamentos()
  println("-----------")

  //o comando for pode agir sobre coleções 
  for(v in listOf(1,2,3,4,5)){
    println("$v é um elemento da lista")
  }
  for(v in setOf(1,2,3,4,5)){
    println("$v é um elemento do conjunto")
  }
  for(par in listOf("um" to 1, "dois" to 2, "tres" to 3)){
    println("$par é uma associação do mapeamento")
  }
}

// conjuntos(sets)
// coleção de dados onde a ordem e a repetição dos elementos não é importante

fun conjuntos(){
  //conjuntos constantes
  val s1 = setOf(1,2,3)
  val s2 = setOf(3,1,1,2,3)
  println("s1 = $s1")
  println("numero de elementos = ${s1.size}")
  println(s1.contains(2))
  println("s2 = $s2")
  println("s1 = s2 ? ${s1==s2}")

  println("--------------")
  //conjuntos mutaveis
  val m1 = mutableSetOf(1,2,3)
  println("5 in m1 = ${m1.contains(5)}")
  println("5 in m1 = ${m1.contains(3)}")
  m1.add(5)
  m1.remove(3)
  println("5 in m1 = ${m1.contains(5)}")
  println("5 in m1 = ${m1.contains(3)}")
}


fun mapeamentos(){
  //implementam uma função que associa valores de um tipo Chave p um tipo Value. 

  // cada chave pode estar associada a apenas um valor destino. caso bote 2, a relação que vale é a ultima
  val m = mapOf(1 to "um", 2 to "dois", 3 to "tres", 4 to "boom")
  println("m = $m")
  println("size = ${m.size}")
  //não significa o primeiro elemento. e sim o elemento associado ao valor 1, ou seja "um"
  println("${m[1]}")
  println("${m[4]}")
  println(m.containsKey(1))  

  //mapeamentos mutaveis
  println("--------------")
  val mm = mutableMapOf("um" to 1,"dois" to 2,"tres" to 3)
  println(mm["um"])
  println(mm["quatro"])
  mm.put("quatro",4) // igual a mm["quatro"] = 4
  println(mm["quatro"])
  mm.remove("quatro") // remove a relação, tanto key qnt value
  println(mm["quatro"])
  println(mm.keys) // retorna o conjunto das chaves
}