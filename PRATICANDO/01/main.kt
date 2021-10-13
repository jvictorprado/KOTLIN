fun fact(num : Int){
  var ret = num
  var f = ret
  for(i in (f-1) downTo 1){
    f*=i
  }
  println("O fatorial de $ret é $f")
}

fun pot(num : Int, exp : Int) : Int{
  var aux = num
  for(i in 1..(exp-1)){
    aux*=num
  }
  return aux;
}

//A partir de 6 o numero fica mt grande e estoura
fun hiperFact(num : Int){
  var ret = num
  // var f = ret
  var first = pot(num,num)
  for(i in (num-1) downTo 1){
    first*= pot(i,i)
  }
  println("O hiper-fatorial de $ret é $first")
}

fun fibo(num : Int){
  var f = num
  var first = 1
  var second = 1
  var aux = 0
  if(f==1 || f==2){
    println("O $f º número da sequencia é 1")
  }else{
    for(i in 3..f){
      aux = first + second
      first = second
      second = aux
    }
    println("O $f º número da sequencia é $aux")
  }
}

fun main(){
  println("7^5 = ${pot(7,5)}")
  fact(4)
  fact(10)
  hiperFact(5)
  fibo(4)
  fibo(10)
}