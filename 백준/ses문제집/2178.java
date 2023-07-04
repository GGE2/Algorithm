
import java.util.*;
import java.io.*;

class Main {

    static class Maze{
        int x;
        int y;
        int count;
        public Maze(int x,int y,int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static boolean[][] visited;
    static int[][] map;
    static int N,M;
    static int res;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++)
                map[i][j] = str.charAt(j)-'0';
        }
        bfs(N-1,M-1);
        System.out.println(res);
    }
    static void bfs(int targetX,int targetY){

        Queue<Maze> q = new ArrayDeque<>();
        q.add(new Maze(0,0,1));
        while(!q.isEmpty()){
            Maze now = q.poll();
            visited[now.x][now.y] = true;
            for(int i=0;i<4;i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(isRange(nx,ny)&&!visited[nx][ny]&&map[nx][ny]==1) {
                    q.add(new Maze(nx, ny, now.count + 1));
                    visited[nx][ny] = true;
                    if(nx==targetX&&ny==targetY){
                        res = now.count+1;
                        break;
                    }
                }
            }

        }

    }
    static boolean isRange(int x,int y){
        if(x>=0&&y>=0&&x<N&&y<M) return true;
        else return false;


    }

}





