fun main() = with(System.`in`.bufferedReader()){

    val N = readLine().toInt()
    var arr = readLine().split(" ").map{it.toLong()}.sorted()
    var answer = 0

    for(idx in arr.indices){
        var left = 0
        var right = N-1
        while(left<right){
            val sum = arr[left]+arr[right]
            if(sum==arr[idx]){
                if(left!=idx&&right!=idx){
                    answer++
                    break
                }else if(left==idx){
                    left++
                }else{
                    right--
                }
            }
            else if(sum>arr[idx]) right--
            else left++
        }
    }

    println(answer)

}
