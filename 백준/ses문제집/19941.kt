fun main() = with(System.`in`.bufferedReader()){

    val (N,K) = readLine().split(" ").map{it.toInt()}
    val eated = BooleanArray(N){false}
    val bench = readLine()
    var answer = 0
    repeat(N){
        val picked = bench[it]
        if(picked=='P'){ //사람인 경우만 체크, 왼쪽에 햄버거가 있으면 가장 먼거, 오른쪽에 햄버거가 있으면 가장 가까운 것
            for(idx in it-K..it+K){
                if(idx in 0 until N){
                    if(bench[idx]=='H'&&!eated[idx]){
                        eated[idx] = true
                        answer++
                        break
                    }
                }
            }
        }
    }
    println(answer)
}
