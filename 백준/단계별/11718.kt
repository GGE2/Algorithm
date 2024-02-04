
fun main() = with(System.`in`.bufferedReader()){

    while(true){
        readLine()?.let{
            if(it.isNotBlank()){
                println(it)
            }
        } ?:break
    }
}
