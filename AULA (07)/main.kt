class Ponto(val x:Float = 0f, val y:Float = 0f){
// //se quiser que o toString mostre os valores em vez do local de memoria
override fun toString() = "Ponto($x,$y)"

//Se quiser que o == sirva pra classes normais faz isso:
  // override fun equals(other:Any?):Boolean{
  //   if(!(other is Ponto))
  //     return false
  //   return this.x==other.x && this.y==other.y 
  // }
}

data class Point(val x:Float, val y:Float){
  operator fun plus(p:Point) = Point(x+p.x,y+p.y) 
  infix fun sub(p:Point) = Point(x-p.x,y-p.y)
}
//FUNÇÃO EXTENSORA. SEMPRE SÃO FINAL
fun Point.sucessor() = Point (x+1,y+1)


fun main() {
  //CLASSE NORMAL
  val p1 = Ponto(1f,2f)
  val p2 = Ponto(1f,2f)
  println(p1)
  println(p2)
  println("p1 = p2? ${p1==p2}")

  println("--------------------------------")  
  //DATA CLASSES
  //TODA DATA CLASS É FINAL 
  val p3 = Point(1f,2f)
  val p4 = Point(1f,2f)
  println(p3)
  println(p4)
  println("p3 = p4? ${p3==p4}")
  
  //OPERATOR
  println("p3 + p4? ${p3+p4}") 
  //INFIX
  println("p3 - p4? ${p3 sub p4}")

  println("--------------------------------")
  //DEFAULT E NAMED
  val p5 = Ponto()
  val p6 = Ponto(y=7f,x=3f)
  println(p5)
  println(p6)

  println("--------------------------------")
  //EXTENSORA
  val p7 = p4.sucessor()
  println(p7)

  println("--------------------------------")
  //PROPRIEDADES
  var t = Teste()
  t.x = 2
  println(t.x)

  println("--------------------------------")
  //TYPEALIAS
  //O PAR VAI SE COMPORTAR COMO UM POINT.. EVITA QUE VOCÊ DEFINA UMA NOVA CLASSE, JÁ QUE O POINT E O PAR TEM O MESMO COMPORTAMENTO
 
  val p8 = Par(1f,2f)
  val p9 = Par(1f,2f)
  println(p8)
  println(p9)
  println("p8 = p9? ${p8==p9}")
  
}
typealias Par = Point

//VALOR DEFAULT 
//Declara a função e já bota um = . Ex:
//fun teste(val a:Int, val b:Int = 0)
//teste(4) == teste(4,0)
//mas pode mudar tbm. ex:
//teste(7,5)



class Teste {
  var x = 0
    get() { println("get chamado") ; return field }
    set(v:Int) { println("set chamado"); field = v }
}
