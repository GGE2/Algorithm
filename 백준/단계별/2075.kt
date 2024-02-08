import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    val N = readLine().toInt()
    repeat(N){
        val arr = readLine().split(" ").map{it.toInt()}
        arr.forEach{ pq.offer(it)}
    }
    var idx = 0
    while(pq.isNotEmpty()&&idx<N-1){
        pq.poll()
        idx++
    }
    println(pq.peek())
}
