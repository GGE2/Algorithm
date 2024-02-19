import kotlin.system.exitProcess
fun main() = with(System.`in`.bufferedReader()) {
    val S = readLine()
    val T = readLine()
    solution(S,T)
    println(0)
}
fun solution(s : String,t : String){
    if(t.length==s.length){
        if(t.equals(s)){
            println(1)
            exitProcess(0)
        }
        return ;
    }
    if(t[t.length-1]=='A') solution(s,t.removeRange(t.length-1,t.length))
    if(t[0]=='B') solution(s,t.removeRange(0,1).reversed())
}
