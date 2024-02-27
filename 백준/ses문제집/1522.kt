fun main() = with(System.`in`.bufferedReader()){

    val str = readLine()
    val len = str.length
    var aLen = 0
    for(ch in str)
        if(ch=='a') aLen++
    var left = 0
    var answer = Int.MAX_VALUE

    while(left<len){
        var cnt = 0
        for(i in left until left+aLen){
            var idx = i%len
            if(str[idx]=='b')cnt++
        }
        left++
        answer = Math.min(answer,cnt)
        if(answer==0) break
    }
    println(answer)

}
