import java.util.*

data class Node(val x : Int,val y : Int,val dist : Int)
val dx = intArrayOf(-1,0,1,0)
val dy = intArrayOf(0,1,0,-1)

fun main() = with(System.`in`.bufferedReader()){

    val (n,m) = readLine().split(" ").map{it.toInt()}
    val map = Array(n){readLine().split(" ").map{ it.toInt() }.toIntArray()}
    val graph = Array(n){IntArray(m){-1} }
    var (startX,startY) = arrayOf(0,0)
    for(i in 0 until n){
        for(j in 0 until m) {
            if (map[i][j] == 2) {
                startX = i
                startY = j
            } else if (map[i][j] == 0) graph[i][j] = 0
        }
    }
    bfs(graph,map,startX,startY)
    for(i in 0 until n){
        for(j in 0 until m){
            if(j!=m-1)print("${graph[i][j]} ")
            else print("${graph[i][j]}\n")
        }
    }
}
fun bfs(graph : Array<IntArray>, map : Array<IntArray>,sx : Int,sy : Int){
    val q : Queue<Node> = LinkedList()
    val visited = Array(graph.size){BooleanArray(graph[0].size)}
    visited[sx][sy] = true
    q.offer(Node(sx,sy,0))
    graph[sx][sy] = 0
    while(q.isNotEmpty()){
        val now = q.poll()

        if(!visited[now.x][now.y]) visited[now.x][now.y] = true
        for(i in 0 until 4){
            val nx = now.x+dx[i]
            val ny = now.y+dy[i]

            if(nx<0||ny<0||nx>=graph.size||ny>=graph[0].size) continue
            if(!visited[nx][ny]&&map[nx][ny]==1){
                q.offer(Node(nx,ny,now.dist+1))
                visited[nx][ny] = true
                graph[nx][ny] = now.dist+1
            }
        }
    }
}
