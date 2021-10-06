fun mainImp() { 
  var c1 = Contador_Imp(2)

  println("c1 = ${c1.get()}")
  c1.incr()
  println("c1 = ${c1.get()}")

//Não rola Aliasing
  var c2 = c1.clone()
  println("c1 = ${c1.get()}")
  println("c2 = ${c2.get()}")
  c2.incr()
  println("c1 = ${c1.get()}")
  println("c2 = ${c2.get()}")

//Rola Aliasing
  var c3 = c2
  println("c2 = ${c2.get()}")
  println("c3 = ${c3.get()}")
  c3.incr()
  println("c2 = ${c2.get()}")
  println("c3 = ${c3.get()}")

}

class Contador_Imp(var valor:Int){
  fun get() = valor
  fun incr():Unit{
    valor = valor + 1
  }
  //Para evitar problemas de Aliasing, cria-se um clone. Isso é mais seguro, mas gasta mais memoria
  fun clone() = Contador_Imp(valor)
}


class Contador_func(val valor:Int){
  fun get() = valor
  fun incr():Contador_func{
    return Contador_func(valor+1)
  }
}


fun main(){
  val c1 = Contador_func(2)

  println("c1 = ${c1.get()}")
  val c2 = c1.incr()
   println("c2 = ${c2.get()}")
}