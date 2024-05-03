
import java.io.*;
import java.util.*;



class Main{

    static class Node{
        int x;
        int y;
        int dir;

        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    static int[] dx = {0,1};
    static int[] dy = {1,0};

    static int N;
    static int[][] map;
    static boolean[][][] visited;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[2][N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs()==-1?"Hing":"HaruHaru");

    }
    public static int bfs(){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0,0,0));
        q.offer(new Node(0,0,1));
        visited[0][0][0] = true;
        visited[1][0][0] = true;
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i=0;i<2;i++){
                int nx = now.x+(dx[i]*map[now.x][now.y]);
                int ny = now.y+(dy[i]*map[now.x][now.y]);
                if(nx>=0&&ny>=0&&nx<N&&ny<N&&!visited[i][nx][ny]){
                    if(nx==N-1&&ny==N-1) return 1;
                    visited[now.dir][nx][ny] = true;
                    q.offer(new Node(nx,ny,i));
                }
            }

        }
        return -1;
    }

}

