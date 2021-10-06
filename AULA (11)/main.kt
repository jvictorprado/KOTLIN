fun main1(){
  for(i in 1..5){
    println("Hello World")
  }
  // equivalente a:
  // 1:
  // repita(10, {c -> println("Bye World")})
  // 2:
  // repita(10){c -> println("Bye World")}
  // 3:
  repita(5){println("Bye World")}
  println("----------------------------------")
  enquantoUsuarioQuiser{println("creu")}
}

typealias FunUnit = (Int) -> Unit

fun repita(n:Int, comando:FunUnit){
  for(x in 1..n)
    comando(x)
}

fun enquantoUsuarioQuiser(com:() -> Unit){
  do{
    com()
    println("Deseja repetir? (S/N)")
    var line = readLine()
  }while(line=="S")
}

//------------------------------------------------------------

//    MANIPULAÇÃO / ACESSO A COLEÇÕES DE DADOS
data class Lista(val n:Int, val prox:Lista?)

fun main(){
  val l1 = Lista(1,Lista(2,Lista(3,null)))

  //versão sem alta ordem
  var atual : Lista? = l1
  while(atual!=null){
    println("Valor da Lista: ${atual.n}")
    atual = atual.prox
  }
  //versão com alta ordem
  forEach(l1){elem -> println("Valor da Lista 1: $elem")}

  //-----------------------------------------------

  // OPERAÇÕES DE TRANSFORMAÇÃO SEM ALTA ORDEM
  //Operação de incrementar
  fun incrementar(l:Lista?):Lista?{
    if(l==null)return null
    return Lista(l.n+1,incrementar(l.prox))
  }
  //Operação de duplicar
  fun duplicar(l:Lista?):Lista?{
    if(l==null)return null
    return Lista(l.n*2,duplicar(l.prox))
  }
  // OPERAÇÕES DE TRANSFORMAÇÃO COM ALTA ORDEM
  fun incrementar2(l:Lista?) = map(l1){n -> n+1}
  fun duplicar2(l:Lista?) = map(l1){n -> n*2}

  var l1_inc = incrementar2(l1)
  forEach(l1_inc){elem -> println("Valor da Lista 1 incrementada: $elem")}
  var l1_dup = duplicar2(l1)
  forEach(l1_dup){elem -> println("Valor da Lista 1 duplicada: $elem")}


  // OPERAÇÕES DE SELEÇÃO SEM ALTA ORDEM
  fun pares(l:Lista?):Lista?{
    if(l==null) return null
    if(l.n%2==0) return Lista(l.n,pares(l.prox))
    return pares(l.prox)
  }
  fun impares(l:Lista?):Lista?{
    if(l==null) return null
    if(l.n%2!=0) return Lista(l.n,impares(l.prox))
    return impares(l.prox)
  }
  // OPERAÇÕES DE SELEÇÃO COM ALTA ORDEM
  
  fun pares2(l:Lista?) = select(l){n -> n % 2 == 0}

  fun impares2(l:Lista?) = select(l){n -> n % 2 != 0}

  val pares_l1 = pares2(l1)
  forEach(pares_l1){elem -> println("Valores pares da Lista 1: $elem")}
  val impares_l1 = impares2(l1)
  forEach(impares_l1){elem ->println("Valores impares da Lista 1: $elem")}


// OPERAÇÕES DE ACUMULAÇÃO SEM ALTA ORDEM
  // fun somatorio(l:Lista?):Int{
  //   var atual = l
  //   var acumulador = 0
  //   while(atual!=null){
  //     acumulador = acumulador + atual.n
  //     atual = atual.prox 
  //   }
  //   return acumulador
  // }
  // fun produtorio(l:Lista?):Int{
  //   var atual = l
  //   var acumulador = 1
  //   while(atual!=null){
  //     acumulador = acumulador * atual.n
  //     atual = atual.prox
  //   }
  //   return acumulador
  // }
  // fun tamanho(l:Lista?):Int{
  //   var atual = l
  //   var acumulador = 0
  //   while(atual!=null){
  //     acumulador+=1
  //     atual = atual.prox
  //   }
  //   return acumulador
  // }
  // OPERAÇÕES DE ACUMULAÇÃO COM ALTA ORDEM
  fun somatorio2(l:Lista?) = acumula(l,0){ac, n -> ac+n}
  fun produtorio2(l:Lista?) = acumula(l,1){ac, n -> ac*n}
  fun tamanho2(l:Lista?) = acumula(l,0){ac, n -> ac+1}
  println("Somatorio de l1_inc = ${somatorio2(l1_inc)}")
  println("Produtorio de l1_inc = ${produtorio2(l1_inc)}")
  println("Tamanho de l1_inc = ${tamanho2(l1_inc)}")
}


fun forEach(prim:Lista?, com: (Int)->Unit){
  //pega o primeiro elemento de uma lista e o comando que vai ser executado para cada elemento da lista
  var atual : Lista? = prim
  while(atual!=null){
    com(atual.n)
    atual = atual.prox
  }
}


fun map(l:Lista?, transform : (Int)-> Int):Lista?{
  //recebe um elem da lista e uma função de transformação e retorna uma lista
  if(l==null)return null
  return Lista(transform(l.n), map(l.prox,transform))
}


fun select(l:Lista?, teste:(Int) -> Boolean):Lista?{
//recebe uma lista e uma função de teste
  if(l==null) return null
  if(teste(l.n)) return Lista(l.n,select(l.prox,teste))
  return select(l.prox,teste)
}


fun acumula(l:Lista?, v0:Int, acum:(Int,Int) -> Int):Int{
//recebe uma lista, um valor inicial e uma função de acumulação
  var atual = l
  var acumulador = v0
  while(atual!=null){
    acumulador = acum(acumulador,atual.n)
    atual = atual.prox
  }
  return acumulador
}

//equivalente ao acumula há o reduce
fun reduce(l:Lista?, v0:Int, acum:(Int,Int) -> Int):Int{
  if(l==null) return v0
  return reduce(l.prox,acum(v0,l.n),acum)
}