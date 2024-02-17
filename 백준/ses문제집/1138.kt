import kotlin.system.exitProcess

fun main() = with(System.`in`.bufferedReader()){

    val N = readLine().toInt()
    val heights = readLine().split(" ").map{it.toInt()}
    permutation(IntArray(N),heights, BooleanArray(N),0,N)
}
fun permutation(arr : IntArray,heights : List<Int>,v : BooleanArray,r : Int, n : Int){
    if(r==n){
        if(isCorrect(arr,heights)){
            arr.forEach{
                print("${it+1} ")
            }
            exitProcess(0)
        }
        return ;
    }
    for(i in 0 until n){
        if(v[i]) continue
        v[i] = true
        arr[r] = i
        permutation(arr,heights,v,r+1,n)
        v[i] = false
    }
}
fun isCorrect(arr : IntArray,heights : List<Int>) : Boolean{
    for(i in arr.indices){
        var bigger = 0
        for(j in 0 until i){
            if(arr[j]>arr[i])bigger++
        }
        if(heights[arr[i]]!=bigger) return false
    }
    return true
}
