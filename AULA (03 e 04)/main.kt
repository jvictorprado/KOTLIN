class Pessoa{
  var nome : String
  var idade : Int
  constructor(n:String, i:Int){
    nome = n
    idade = i
  }
  fun imprime(){
    println("Pessoa: $nome de $idade anos")
  }
}


class Pessoa2(n:String, i:Int){
  // aqui o n e o i são argumentos do construtor e não variaveis da classe
  //poderia ser : var nome = n
  var nome : String = n
  var idade : Int = i
  fun imprime(){
    println("Pessoa: $nome de $idade anos")
  }
}

class Pessoa3(var nome:String, var idade:Int){
  fun imprime(){
    println("Pessoa: $nome de $idade anos")
  }
}

class Pessoa4(var nome:String, var idade:Int)


fun main(){
  var p : Pessoa = Pessoa("João", 24) 
  p.imprime()
  var p2 : Pessoa2 = Pessoa2("Cristina", 25)
  p2.imprime()
  var p3 : Pessoa3 = Pessoa3("Aurélio", 54)
  p3.imprime()

  var stu = Student("Male",24,"Victor","Ecomp")
  stu.printa()

  var x : Person = stu
  
  //equivalente ao instanceOf
  if(x is Student){
    println("X is a student")
  } else{
    println("X isn't a student")
  }

  //equivalente ao cast
  var y = x as Animal

  // Aqui da erro, pq kotlin tem testes inteligentes... ent nesse caso vc tem que fazer uma condicional
  // var z : Person? = x 
  // z.printa()
}

open class Animal(var gender:String, var age:Int)

open class Person(gender:String, age:Int, var name:String) : Animal(gender,age){
  open fun printa(){
    println("""
    -name:$name
    -gender:$gender
    -age:$age
    """)
  }
}

open class Student(gender:String, age:Int, name:String, var classe:String) : Person(gender,age,name){
  override fun printa(){
    println("""
      -name:$name
      -gender:$gender
      -age:$age
      -class:$classe
    """)
  }
}

//todo objeto não pode ser null, a não ser que vc bote uma ? depois dele... isso é bom pq avisa ao programador que a função ou objeto pode ser nulo.. 


//Conceito que kotlin traz : a ideia de objects
//Só existe essa instancia
// Singleton é um padrão de projeto de software. Este padrão garante a existência de apenas uma instância de uma classe, mantendo um ponto global de acesso ao seu objeto. 
object Joao : Student("Male",30,"Johny","Direito")


// outro caso é o companion: um estudante que é tanto classe qnt objeto.. ele vai ter as propriedades que os estudantes tem e propriedades especificas de alguns estudantes

companion object Student{
  val institution = "POLI"
}