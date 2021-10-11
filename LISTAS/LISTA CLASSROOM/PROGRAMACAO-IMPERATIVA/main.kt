fun main() {
  pa(1,4,6)
  println()
  println("b) A soma dos primos entre 2 e 100 = ${somaPrimos(2,100)}")
  fibo(6)
  println()
  println("d)6 primeiras linhas do triângulo de pascal =")
  pascal(6)
}

// a) Listar uma progressão aritmética a partir do seu valor inicial, razão e número de elementos
fun pa(n1:Int, razao:Int, n:Int){
  var aux_n1 = n1
  var aux_razao = razao
  var aux_n = n
  print("a) PA($n1,$razao,$n) = ")
  while(aux_n>0){
    print("$aux_n1 ,")
    aux_n1 += aux_razao
    aux_n -=1 
  }
}

// b) Soma de todos os valores primos entre 2 e 100
fun primo(num:Int):Boolean{
  for (i in 2..num-1) {
    if (num % i == 0)
      return false;   
  }
  return true;
}

fun somaPrimos(a:Int,b:Int):Int{
  var total = 0
  for(i in (a+1)..(b-1)){
    if(primo(i))
      total = total + i
  }
  return total
}

// c) Imprimir os n-primeiros números de uma série de fibonacci
fun fibo(num:Int){
  var a = 1
  var b = 0
  var aux = 0
  print("c) Os $num primeiros numeros da série de fibonacci = ")
  for(i in 1..num){
    print("$a, ")
    aux = a
    a += b
    b = aux
  }
}

// d) Imprimir as n-primeiras linhas do triângulo de pascal
fun pascal(linhas:Int){
  var coef = 1
  for (i in 0..linhas - 1) {
    for (j in 0..i) {
      if (j == 0 || i == 0)
        coef = 1
      else
        coef = coef * (i - j + 1) / j

      System.out.printf("$coef ")
    }
    println()
  }
}