fun main(args: Array<String>) {
  val l1 = ListaFun(5,null)
  val l2 = insereNoFim(2,l1)
  val l3 = insereNoFim(9,l2)
  println("l1= $l1")
  println("l2= $l2")
  println("l3= $l3")
  val l4 = (l2.prox)
  println("l4= $l4")
  val l5 = copyList(l4)
  println("l5= $l5")
  val l6:ListaFun = ListaFun(7,(ListaFun(1,null)))
  val l7:ListaFun = ListaFun(8,ListaFun(3,ListaFun(4,null)))
  println("l6= $l6")
  println("l7= $l7")
  val l8 = concatListas(l6,l7)
  println("l8 = $l8")
  println(nEzimo(3,l8))
}

data class ListaFun(val info:Int, val prox:ListaFun?)

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

//– Concatenar duas listas
fun concatListas(l1:ListaFun,l2:ListaFun):ListaFun{
  if(l2.prox==null){
    return insereNoFim(l2.info,l1)
  }else{
    return concatListas(insereNoFim(l2.info,l1),l2.prox)
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

// fun inserePos(num:Int,pos:Int,l:ListaFun):ListaFun{
// }

// fun removePos(pos:Int,l:ListaFun){

// }

// fun modifVal(num:Int,l:ListaFun){

// }

// fun somaListas(){

// }