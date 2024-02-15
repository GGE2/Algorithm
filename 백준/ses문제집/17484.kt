val dx = intArrayOf(1,1,1)
val dy = intArrayOf(-1,0,1)
var min = Int.MAX_VALUE
fun main() = with(System.`in`.bufferedReader()){
    val (N,M) = readLine().split(" ").map{it.toInt()}
    val map = Array(N){readLine().split(" ").map{it.toInt()}}
    var x = 0
    repeat(M){
        val v = Array(N){BooleanArray(M)}
        dfs(map,v,x,it,-1,map[x][it])
    }
    println(min)
}

fun dfs(graph : Array<List<Int>>,visited : Array<BooleanArray>, x : Int, y:Int, direction : Int,total : Int){
    if(x==graph.size){
        min = Math.min(min,total)
        return ;
    }
    visited[x][y] = true
    for(i in 0 until 3) {
        if (i == direction) continue
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx >= visited.size) dfs(graph, visited, nx, ny, i, total)
        else if (nx >= 0 && ny >= 0 && ny < visited[0].size && !visited[nx][ny]) {
            dfs(graph, visited, nx, ny, i, total + graph[nx][ny])
        }
    }
    visited[x][y] = false
}
