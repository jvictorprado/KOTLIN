fun main(args: Array<String>) {
  println("Criando a lista l1:")
  val l1 = ListaFun(5,null)
  println("l1= $l1\n")
  println("Criando l2 a partir de l1 inserindo '2' no fim:")
  val l2 = insereNoFim(2,l1)
  println("l2= $l2\n")
  println("Criando l3 a partir de l2 inserindo '9' no fim:")
  val l3 = insereNoFim(9,l2)
  println("l3= $l3\n")

  println("Criando l4 usando o prox de l2:")
  val l4 = (l2.prox)
  println("l4= $l4")
  println("***CRIANDO A COPIA DE l4 -> l5")
  val l5 = copyList(l4)
  println("l5= $l5\n")

  println("Criando l6 e l7:")
  val l6:ListaFun = ListaFun(7,(ListaFun(1,null)))
  // val l6:ListaFun? = null
  val l7:ListaFun = ListaFun(8,ListaFun(3,ListaFun(4,null)))
  println("l6= $l6")
  println("l7= $l7")
  println("***CONCATENANDO l6 e l7 = l8:")
  val l8 = concatListas(l6,l7)
  println("l8 = $l8\n")

  print("***OBTENDO O N-ESIMO ELEMENTO DE l8:")
  println(" ${nEzimo(2,l8)}\n")

  println("***REMOVENDO O N-ESIMO ELEMENTO DE l8, criando l9:")
  val l9 = removereNEsimo(2,l8)
  println("l9 = $l9\n")

  println("***INSERINDO '5' NA N-ESIMA POSIÇÃO DE l9, criando l10:")
  val l10 = inserePos(5,2,l9)
  println("l10 = $l10\n")

  println("***SOMANDO l6 e l7 para obter l11")
  val l11 = somarlistas(l6,l7)
  println("l11 = $l11\n")

  println("***MODIFICANDO O VALOR DA POSIÇÃO '1' DE l11, criando l12:")
  val l12 = modificarValor(1,20,l11)
  println("l12 = $l12")
}

data class ListaFun(val info:Int, val prox:ListaFun?)
fun tamanho(l:ListaFun?):Int{
  if (l == null) return 0
  else return tamanho(l.prox) +1
}


//METODO ADD
fun insereNoFim(v:Int, n:ListaFun?):ListaFun {
   if (n==null)
      return ListaFun(v,null)
   else
	  return ListaFun(n.info, insereNoFim(v,n.prox)) 
}

//– Copiar uma lista
fun copyList(l:ListaFun?):ListaFun?{
  if(l!=null){
    val i = l.info
    val p = l.prox
    return ListaFun(i,p)
  }else{
    return null
  }
}

//– Obter o n-esimo elemento de uma lista
fun nEzimo(num:Int,l:ListaFun?):Int{
  if(l!=null){
    if(num==0){
      return l.info
    }
    return nEzimo(num-1,l.prox)
  }
  return -1
}

//- Inserir um valor na N-esima posição
fun inserePos(valor:Int, pos:Int, l:ListaFun?):ListaFun?{
  //se a posição passada for igual ao tamanho da lista significa que vc quer adicionar no fim dela. Esse primeiro if serve para isso, ele é opcional, pq não faz sentido vc fazer isso já que existe a função insereNoFim
  if(pos == tamanho(l)){
    return insereNoFim(valor,l)
  }else{
    if (l == null) return null
    else if (pos == 0) return ListaFun(valor,l)
    else return ListaFun(l.info, inserePos(valor,pos-1,l.prox))
  }
}

//- Remover um valor da N-ezima posição
fun removereNEsimo(pos:Int,l:ListaFun?):ListaFun?{
  if (l == null ) return  null
  else if ( pos==0 ) return l.prox
  else return ListaFun(l.info,removereNEsimo(pos-1, l.prox))
}

//- Modificar um valor da lista
fun modificarValor(pos:Int, valor:Int, l:ListaFun?):ListaFun?{
  if (l == null) return null
  else if (pos == 0) return ListaFun(valor,l.prox)
  else return ListaFun(l.info,modificarValor(pos-1,valor,l.prox))
}


//– Concatenar duas listas  
fun concatListas(l1:ListaFun?,l2:ListaFun?):ListaFun?{
  if(l1 == null) return l2
  else if(l2 == null) return l1
  else if(l2.prox==null){
    return insereNoFim(l2.info,l1)
  }else{
    return concatListas(insereNoFim(l2.info,l1),l2.prox)
  }
} 

//- Somar 2 listas
fun somarlistas(l1:ListaFun?,l2:ListaFun?):ListaFun?{
  if(l1 == null ) return l2
  else if ( l2 == null ) return l1
  else return ListaFun(l1.info + l2.info, somarlistas(l1.prox,l2.prox))
}
