fun main() = with(System.`in`.bufferedReader()){

    val T = readLine().toInt()
    val sb = StringBuilder()
    repeat(T){
        val N = readLine().toInt()
        val arr = readLine().split(" ").map{it.toInt()}.reversed()
        var max = arr[0]
        var answer : Long = 0
        for(idx in 1 until N){
            if(max<arr[idx]) max = arr[idx]
            else answer+=max-arr[idx]
        }
        sb.append("${answer}\n")
    }
    println(sb.toString())
}

