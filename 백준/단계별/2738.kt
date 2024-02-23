fun main() = with(System.`in`.bufferedReader()){

    val (N,M) = readLine().split(" ").map{it.toInt()}

    val arr1 = Array(N){readLine().split(" ").map{it.toInt()}}
    val arr2 = Array(N){readLine().split(" ").map{it.toInt()}}

    val sb = StringBuilder()
    for(i in 0 until N){
        for(j in 0 until M){
            sb.append("${arr1[i][j]+arr2[i][j]} ")
        }
        sb.append("\n")
    }
    println(sb.toString())
}
