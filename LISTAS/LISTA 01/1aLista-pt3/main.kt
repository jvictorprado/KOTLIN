//TA FEIOSO, AJEITA ISSO


fun main(){ 
  val n = 4; // Number of disks 
    torreHanoi(n, 'A', 'C', 'B') // A, B and C are names of rods 
}

fun torreHanoi(n:Int,from_rod:Char,to_rod:Char,aux_rod:Char){ 
  if (n == 1) { 
    println("Move disk 1 from rod $from_rod to rod $to_rod ") 
  }else{
    torreHanoi(n - 1, from_rod, aux_rod, to_rod)
    println("Move disk $n from rod $from_rod to rod $to_rod")
    torreHanoi(n - 1, aux_rod, to_rod, from_rod)
  }
} 
 
 