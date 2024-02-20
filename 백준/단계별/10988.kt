fun main() = with(System.`in`.bufferedReader()){
    val word = readLine()
    var start = 0
    var end = word.length-1

    while(start<=end){
        if(word[start++]!=word[end--]){
            println(0)
            return ;
        }
    }
    println(1)
}
