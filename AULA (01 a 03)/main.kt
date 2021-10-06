//AULA 01
// EXEMPLOS DE ARMADILHAS EM PROG TRADICIONAL

// EX1) vai imprimir "Bom dia!" pq 'o' é C2 em tempo de execução. Problema chamado de monotonicidade.
//class C1{
//   void f(){print("Olá mundo!");}
// }
// class C2 extends C1{
//  void f(){print("Bom dia!");}
// }

// fun main(){
//   C1 o = new C2();
//   o.f();
// }

// ------------------------------------------------
// EX2) Aliasing
// class C{ int x;}
// fun (a:C, b:C){
//   a.x = 1;
//   b.x = 2;
//   print(a.x + b.x); 
// }
// void main (){
//   C o = new C();
//   f(o,o);
// }

// ------------------------------------------------
// EX3) NullPointers Errors
// class Aluno {
//   String nome; ...
// }

// Aluno obtemAluno(){
//   if(alguma coisa) return null;
  
// }

// void main(){
//   Aluno a = obtemAluno();
//   print(a.nome);
// }

// PRINCIPIO FUNDAMENTAL DA PROGRAMAÇÃO FUNCIONAL
// - VARIAVEIS NÃO PODEM SER MODIFICADAS(UMA PARTE DOS ERROS OCORREM POR CAUSA DA LIBERDADE QUE OS PROGRAMADORES TEM EM MODIFICAR AS VARIAVEIS)



// // AULA 02

fun main(){
  // var i : Int = 5  n existe conversão automatica de tipos
  // var l : Long = i
  
  var x : Int = 10
  var y = x // inferencia de tipo(n precisa dizer que é Int)

  //String templates
  println("Valor da variavel x = $x")

  x = 2*x +1

  println("""
      -Novo valor da variavel x = $x
      -Valor antigo da variavel x = $y
  """.trimIndent())

  println(soma(2,56))
  println(getBigger(224,43))
  println("TESTES WHEN")
  println(testWhen(3))
  println(testWhen2(1))
  testWhiles(6,6)
  testFor()
}

//os parâmetros são val (constantes)
fun soma(a : Int, b : Int) : Int{
  return a+b;
}

fun getBigger(a : Int, b : Int): Int{
  var bigger : Int = if (a>b) a else b
  return bigger
}


// da pra fazer o contrario.. retornando o num
fun testWhen(a : Int) : String{
  when(a){
    1 -> return "Um"
    2 -> return "Dois"
    else ->{
      return "Outro valor"
    }
  }
}

fun testWhen2(a : Int) : String{
  var ret : String
  when{
    a == 1 -> ret = "Um"
    a == 2 -> ret = "Dois"
    else ->{
      ret = "Outro"
    } 
  }
  return ret
}

fun testWhiles(a:Int, b:Int){
  println("TESTE WHILE")
  var aux: Int = 0;
  var aux2: Int = 0;
  if(a>aux && b>aux2){
    while(a>aux){
      println("$aux")
      aux++
    }
    do{
      println("$aux2")
      aux2++
    }while(b>aux2)
  }
}

fun testFor(){
  println("TESTES FOR")
  for(i in 1..10){
    print("-> $i")
  }
  println()
  for(j in 1..15 step 3){
    print("-> $j")
  }
  println()
  for(k in 15 downTo 1 step 2){
    print("-> $k")
  }
  println()
} 