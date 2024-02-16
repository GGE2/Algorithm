fun main() = with(System.`in`.bufferedReader()){

   val (N,M) = readLine().split(" ").map{it.toInt()}
   val sb = StringBuilder()
   val map = HashMap<String,Int>()
   repeat(N){
       map[readLine()] = -1
   }
   repeat(M){
       val arr = readLine().split(",").map{map.remove(it)}
       sb.append("${map.size}\n")
   }
   print(sb.toString())
}
