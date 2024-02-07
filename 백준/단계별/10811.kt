fun main() = with(System.`in`.bufferedReader()){
    val (N,M) = readLine().split(" ").map{it.toInt()}
    val arr = IntArray(N){0}
    repeat(N){
        arr[it] = it+1
    }
    repeat(M){
        val (i,j) = readLine().split(" ").map{it.toInt()}
        val tempArr = arr.slice(i-1..j-1).reversed()
        var index = 0
        for(idx in i-1..j-1) arr[idx] = tempArr[index++]
    }
    arr.forEach{print("${it} ")}
}
