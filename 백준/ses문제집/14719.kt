import java.util.*

fun main() = with(System.`in`.bufferedReader()){

    val (H,W) = readLine().split(" ").map{it.toInt()}
    val map = Array(H){IntArray(W){0} }
    val st = StringTokenizer(readLine())
    repeat(W){
        val height = st.nextToken().toInt()
        for(i in H-height until H)
            map[i][it] = 1
    }
    var (x,left,right,answer) = arrayOf(0,0,0,0)
    var continued = false
    while(x<H){
        if(continued){ //이전에 빗물을 찾은경우
            if(map[x][right]==1){
                answer+=right-left-1
                left=right++
            }else{
                right++
            }
        }else{ //처음 찾은경우
            if(map[x][left]==1){
                continued = true
                right = left+1
            }else{
                left++
            }
        }
        if(left>=W||right>=W){
            x++
            left = 0
            right = 0
            continued = false
        }
    }
    println(answer)
}
