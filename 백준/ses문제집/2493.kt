import java.util.*

data class Top(val height : Int, val idx : Int)

fun main() = with(System.`in`.bufferedReader()){
    val N = readLine().toInt()
    val K = IntArray(N)
    val sb = StringBuilder()
    val stack = Stack<Top>()
    val st = StringTokenizer(readLine())
    repeat(N){
        val num = st.nextToken().toInt()
        while(stack.isNotEmpty()){
            if(stack.peek().height<num){
                stack.pop()
            }else{
                sb.append("${stack.peek().idx+1} ")
                stack.push(Top(num,it))
                break
            }
        }
        if(stack.isEmpty()) {
            stack.push(Top(num,it))
            sb.append("0 ")
        }
    }
    println(sb.toString())
}
