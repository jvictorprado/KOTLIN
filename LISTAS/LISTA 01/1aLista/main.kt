fun main(){
  
  println("""1)
  Calcule 12^4 = ${potencia(12f,4f)}""")

  println("""2)
  Calcule 10! = ${fat(10)}""")
  
  println("""3)
  Calcule soma_pa(1,4,6) = 1+5+9+13+17+21 = ${soma_pa(1,4,6)}""")
  
  println("""4)
  Quantas vezes o digito 2 aparece no número 762021192?  ${incidencia(2,762021192)}""")
  
  println("""5)
  Calcule MDC de 45 e 15 = ${mdc(45,15)}""")
  
  println("""6)
  O 6º número da sequencia de fibonacci é = ${fibo(6)}""")
  
  println("""7)
  Calcule o valor do elemento de coluna 3 e linha 4 
  do triangulo de pascal. = ${pascal(3,4)}""")
}

//POTENCIA
fun potencia(num:Float, exp:Float):Float{
  if(exp<0){
    val pos = exp*-1
    return 1/potencia(num,pos)
  }else if(exp==0f){
    return 1f
  }else{
    return num * potencia(num,exp-1)
  }
}

//FATORIAL
fun fat(num:Int) : Int{
  if(num<=1){
    return 1
  }else{
    return num * fat(num-1)
  }
}

//SOMATORIO DE UMA PA
fun soma_pa(n1:Int, razao:Int, n:Int) : Int{
  if(n==1){
    return n1
  }else{
    return n1+soma_pa(n1+razao, razao, n-1)
  }
}

//MDC
fun mdc(a:Int, b:Int) : Int{
  if ((a % b) == 0) {
    return b
  } else if ((b % a) == 0) {
      return a
    } else {
        val maior = if (a > b) a else b
        val menor = if (a < b) a else b
        val r = maior % menor
        return mdc(menor,r)
      }
}


//FIBONACCI
fun fibo(num:Int) : Int{
  if(num<=0){
    return 0
  } else if(num==1 || num==2){
    return 1
  } else{
    return fibo(num-2) + fibo(num-1)
  }
}


//TRIANGULO DE PASCAL
fun pascal(coluna:Int, linha:Int) : Int{
  if(coluna==linha || coluna ==0){
    return 1
  }else{
    return pascal(coluna-1,linha-1) + pascal(coluna,linha-1)
  }
}

//QUANTAS VEZES O DIGITO APARECE NO NUMERO
fun incidencia(d:Int, num:Int):Int{
  if(num<10){
    if(num==d){
      return 1
    }else{
      return 0
    }
  }else{
    val r = num%10
    if(r==d){
      return 1+incidencia(d,num/10)
    }else{
      return incidencia(d,num/10)
    }
  } 
}

