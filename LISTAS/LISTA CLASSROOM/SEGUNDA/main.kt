//2a) Qual a saída do seguinte programa em Kotlin?
 fun main() {
  val v1 = run {
    println("calculo de v1")
    2 + 3
  }

  val v2 by lazy {
    println("calculo de v2")
    5
  }

  val v3 by lazy {
    println("calculo de v3")
    v1+v2
  }

  val v4 by lazy {
    println("calculo de v4")
    v2+v1
  }

  println(v4)
}

// 1 - Será calculado o valor de v1 (v1 = 5), pois ele usa o modelo de avaliação tradicional (Eager) e não precisa ser necessário (ou chamado) para ser calculado.
// Na primeira linha será impresso : "calculo de v1"
// 2 - Os valores de v2, v3 e v4 ainda não são calculados, pois esses valores usam o modelo de avaliação tardia (lazy) e só serão calculados quando requisitados.
// 3- v4 é requisitado. Dessa forma, na proxima linha será impresso "calculo de v4" .  Além disso, os valores v2 e v1 são requisitados para se calcular o valor de v4. 
// Assim, ao requisitar o valor v2 será impresso na proxima linha "calculo de v2" e será calculado o valor de v2 (v2 = 5). 
// O valor de v1 já havia sido calculado. Então, somando os valores de v2 e v1 é calculado o valor de v4.
// 4- Na ultima linha é impresso o valor de v4 : "10"
// 5- A saída programa será:
// calculo de v1
// calculo de v4
// calculo de v2
// 10
