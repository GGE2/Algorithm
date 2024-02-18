fun main() = with(System.`in`.bufferedReader()){
    val N =  readLine().toInt()
    if(N%2==0) println("CY") else println("SK")
}
