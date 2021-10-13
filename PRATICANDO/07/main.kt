fun main(){
  println(f1(27,::dobro))
  //-------------------
  val op = calculadora(3)
  println(op(56,56))
  //-------------------
  val d = ::dobro 
  val s = ::sucessor
  val c = combina(d,s)
  println(c(11))
  //-------------------
  println("QUESTÕES - FUNÇÕES 1ª CLASSE")
  println(potenciaFuncao(3,s))
  println(potenciaFuncao3(3,1,s))
  var funcao : Fun = {x->(x*x) - (10*x) - 5}
  println(maximo(1,20,funcao))
}

typealias Fun = (Int) -> Int

fun sucessor(n:Int) = n+1
fun dobro(n:Int) = n*2
fun f1(p:Int, f: Fun){
  println(f(p))
}
//---------------------------
fun calculadora(op:Int) : (Int,Int) -> Int =
  when(op){
    1 -> {x,y -> x+y}
    2 -> {x,y -> x-y}
    3 -> {x,y -> x*y}
    4 -> {x,y -> x/y}
    else -> {x,y -> 0}
  }


//---------------------------

fun combina(f:Fun, g:Fun): Fun = {x-> f(g(x))}


//---------------------------
//QUESTÕES PDF

fun potenciaFuncao(n:Int, f:Fun) : Int{
  if(n==1) return f(1)
  return f(potenciaFuncao(n-1,f))
}

fun potenciaFuncao2(vzs:Int, n:Int, f:Fun):Int{
  var aux = n
  var ret = 0
  var x = vzs
  while(x>0){
    ret = f(aux)
    aux = ret
    x-=1
  }
  return ret
}

fun potenciaFuncao3(vzs:Int, n:Int, f:Fun):Int{
  if(vzs==1) return f(n)
  return potenciaFuncao3(vzs-1,f(n),f)
}

fun maximo(i:Int,f:Int, fn:Fun):Int{
  var start = i+1 
  var maior = fn(start+1) 
  while(start<f){
    if(fn(start) > maior)
      maior = fn(start)
    start+=1
  }
  return maior
}

// 2 -21 MAIOR
// 3 -26
// 4 -29
// 5 -30
// 6 -29
// 7 -26
// 8 -21
// 9 -14 MAIOR
// 10 -5
// 11 6
// 12 19
// 13 34
// 14 51