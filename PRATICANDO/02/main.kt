open class Animal(var age:Int, gender:String){
  fun makeBirthday(){
    age++
  }
}

open class Mamal(furColor:String) : Animal(age,gender)

class Reptile(scaleColor:String) : Animal(age,gender)

class Fish(scaleColor:String) : Animal(age,gender){
  fun swim(){
    println("This fish is swimming now!")
  }
}

class Bird(featherColor:String) : Animal(age,gender){
  fun fly(){
    println("This bird is flying now!")
  }
}

open class Human(var name:String) : Animal(age,gender){
  fun 
}