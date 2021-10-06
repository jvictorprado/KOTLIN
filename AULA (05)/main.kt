fun main() {
 // println(summation(7))
  testHours()
}

// fun summation(n:Int):Int {
//   if(n==0) 
//     0 
//   else 
//     n+summation(n-1)
// }


//classe imperativa
class Hour(val hour:Int, val min:Int){
  // caso queira que o == pegue 
  // override fun equals(other:Any?):Boolean{
  //   val o = other as Hour
  //   return (hour==o.hour && min == o.min)
  // }
}

//classe funcional
data class NHour(val hour:Int, val min:Int)

fun testHours(){
  //Comparação pelo endereço de memoria
  val h1 = Hour(10,30)
  val h2 = Hour(10,30)
  println(h1==h2)
  //Comparação pelo conteudo
  val h3 = NHour(10,30)
  val h4 = NHour(10,30)
  println(h3==h4)
}




