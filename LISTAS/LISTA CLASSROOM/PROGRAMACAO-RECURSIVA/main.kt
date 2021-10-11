fun main(){
  println("a) PA(1,4,6) = ${pa(1,4,6)}")
  println()

  println("b) A soma de todos os valores primos entre 2 e 100 = ${somaPrimos(2,100)}")
  println()
  
  println("c) N-primeiros nº de uma série de fibonacci = ${imprimeFibo(6)}")
  println()

  println("d) N-primeiras linhas do triângulo de pascal =")
  imprimePascal(6)
}

// a) Listar uma progressão aritmética a partir do seu valor inicial, razão e número de elementos
fun pa(n1:Int, razao:Int, n:Int) : String{
  if(n==1){
    return n1.toString()
  }else{
    return n1.toString()+", " + pa(n1+razao, razao, n-1)
  }
}

// b) Soma de todos os valores primos entre 2 e 100
fun somaPrimos(a:Int, b:Int):Int {
  if (a == b-1){
    return -2
  }else{
      if(primo(a)){
        return  a + somaPrimos(a + 1, b)
      }
      return somaPrimos(a + 1, b)
  }        
}

fun primo(num:Int, aux:Int=2):Boolean{
  if(aux == num){
    return true
  }else{
    if(num % aux== 0){
      return false
    }else{
      return primo(num,aux+1)
    }
  }
}

// c) Imprimir os n-primeiros números de uma série de fibonacci
fun imprimeFibo(num:Int):String{
  if(num==2){
    return "1, 1"
  }else{
    return imprimeFibo(num-1) + ", " + fibo(num).toString() 
  }
}

fun fibo(num:Int):Int{
  if(num<=0){
    return 0
  }else if(num==1 || num==2){
    return 1
  }else{
    return fibo(num-2) + fibo(num-1)
  }
}


//d) Imprimir as n-primeiras linhas do triângulo de pascal

fun pascal(linha:Int,coluna:Int) : Int{
  if(coluna>linha){
    return 0
  }else if(coluna==linha || coluna ==0){
    return 1
  }else{
    return pascal(linha-1,coluna) + pascal(linha-1,coluna-1)
  }
}

fun imprimePascal(num:Int, linha:Int = 0, coluna:Int = 0):String{
  if(linha>=num){
    return ""
  }
  if(coluna>linha){
    println()
    return imprimePascal(num,linha+1,0)
  }
  print("${pascal(linha,coluna)} ")
  return imprimePascal(num,linha,coluna+1)
}
