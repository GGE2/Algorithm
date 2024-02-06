fun main() = with(System.`in`.bufferedReader()){
    val N = readLine().toInt()
    var answer = 0
    for(i in 0 until N){
        for(j in 0 until N)
            if(i!=j) answer++
    }
    println(answer)
}
