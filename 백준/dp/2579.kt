fun main() = with(System.`in`.bufferedReader()){

    val N = readLine().toInt()
    val dp = IntArray(N+1){0}
    val arr = IntArray(N+1){0}

    for(i in 1..N)
        arr[i] = readLine().toInt()

    when(N){
        1->dp[1] = arr[1]
        2->{
            dp[1] = arr[1]
            dp[2] = arr[1]+arr[2]
        }
        else->{
            dp[1] = arr[1]
            dp[2] = arr[1]+arr[2]

            for(i in 3..N){
                dp[i] = Math.max(dp[i-3]+arr[i-1],dp[i-2]) + arr[i]
            }
        }
    }
    println(dp[N])
}
