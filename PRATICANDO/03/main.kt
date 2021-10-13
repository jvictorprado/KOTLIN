fun main(args: Array<String>) {
  println("IMPRIMINDO O TRIANGULO DE PASCAL:")
  triangle()
  println(pascal(4,4))
}

//TRIANGULO DE PASCAL
fun pascal(coluna:Int, linha:Int) : Int{
  if(coluna==linha || coluna ==0){
    return 1
  }else{
    return pascal(coluna-1,linha-1) + pascal(coluna,linha-1)
  }
}

fun triangle(){
  for(i in 0..10){
    for(j in 0..i){
      print(" ${pascal(j,i)} ")
    }
    println("")
  }
}