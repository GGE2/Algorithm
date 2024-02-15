fun main() = with(System.`in`.bufferedReader()){

    val N = readLine()
    var num = 0
    var nIdx = 0
    while(num++<=30000){
        val str = num.toString()
        for(i in 0 until str.length){
            if(str[i]==N[nIdx]) nIdx++
            if(nIdx==N.length){
                println(num)
                return ;
            }
        }
    }

}
