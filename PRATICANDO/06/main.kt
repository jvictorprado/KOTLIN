fun main(){
println("FUNÇÕES COMO ARGUMENTOS DE FUNÇÕES")
f1(::sucessor)
f1(::dobro)
//----------------------
println("FUNÇÕES COMO RESULTADOS DE FUNÇÕES")
val f2 = seleciona(2)
println(f2(3))
println(seleciona(3)(4))
//-----------------------
println("CLOSURES")
val g1 = soma(3)
println(g1(4))
println(soma(3)(4))
//-----------------------
println("FUNÇÕES QUE RECEBEM FUNÇÕES E RETORNAM FUNÇÕES")
val a = {x : Int -> x + 1}
val b = {x : Int -> 2 * x}
val c = combina2(a,b) //c = {x -> 2*(x+1)}
println(c(3))
val d = combina2(a, {x->3*x}) //d = {x:Int -> 3*(x+1)}
println(d(3))
//-----------------------
println("EXEMPLOS DE USO")
repita(10,{x -> println("$x elefante(s) incomoda(m) muita gente")})
//Se o ultimo argumento for um função ele pode ser adicionado fora dos parenteses
}

//        FUNÇÕES COMO ARGUMENTOS DE FUNÇÕES
fun f1( f : (Int) -> Int){
  println(f(2))
}
fun sucessor(n:Int) = n+1
fun dobro(n:Int) = n*2


//        FUNÇÕES COMO RESULTADOS DE FUNÇÕES
//funções podem retornar funções como resultado
fun seleciona(n:Int) : (Int) -> Int =
  when(n){
    1->{x:Int -> x+1}
    2->{x:Int -> 2*x}
    3->{x:Int -> x*x}
    4->{x:Int -> x+8}
    else ->{x:Int -> 0}
  }


  //        CLOSURES
//Um closure premite a uma expressão lambda usar todas as variáveis visíveis quando uma função é definida
fun soma(n:Int): (Int) -> Int = {x -> x+n}


//         FUNÇÕES QUE RECEBEM FUNÇÕES E RETORNAM FUNÇÕES
fun combina(f : (Int)->Int, g : (Int)->Int) : (Int)-> Int =
  {x : Int -> g(f(x))}
//usando typealias (DA NO MESMO)
typealias Fun = (Int) -> Int
fun combina2(f:Fun, g:Fun) : Fun = {x:Int -> g(f(x))}


//         EXEMPLOS DE USO 
fun repita(n:Int, com:(Int)->Unit){
  for(x in 1..n)
    com(x)
}
