import kotlin.io.*
import java.io.*
import java.net.*

fun main(){
  benchmark("Ler Arquivo"){
    // tempo pra ler um arquivo ~ 7ms
    // tempo pra ler uma pagina web ~ 178ms
    //val src = URL("http://www.google.com")
    val src =  File("ola.txt")
    val str = src.readText()
    println("conteudo = $str")
  }
  
}

fun benchmark(name:String, com : ()-> Unit){
  val inicio = System.currentTimeMillis()
  com()
  val fim = System.currentTimeMillis()
  println("Tempo para executar $name = ${fim-inicio}ms")
}