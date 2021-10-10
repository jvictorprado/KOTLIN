fun main(){
  for(i in 99 downTo 0){
    verso(i)
  }
}

fun qtd(num:Int):String{
  when{ 
    num==0 -> return "no more bottles"
    num==1 -> return "1 bottle" 
    else -> return "$num bottles" 
    }
}

fun verso(num: Int){
  if(num!=0){
    println("""${qtd(num)} of beer on the wall, ${qtd(num)} of beer.
    Take one down and pass it around, ${qtd(num - 1)} of beer on the wall.
    """)
  }else{
    println("""N${qtd(num).substring(1)} of beer on the wall, ${qtd(num)} of beer.
    Go to the store and buy some more, ${qtd(99)} of beer on the wall.""")
  }
}