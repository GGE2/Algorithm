
import java.util.*;
import java.io.*;

class Main {

    static class Maze{
        int x;
        int y;
        int blocks;
        public Maze(int x,int y, int blocks){
            this.x = x;
            this.y = y;
            this.blocks = blocks;
        }
    }
    static int[][] map;
    static int[][] v;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int N,M;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new int[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j)-'0';
                v[i][j] = Integer.MAX_VALUE;
            }
        }
        if(N==1&&M==1) System.out.println(0);
        else System.out.println(dijkstra());
    }
    static int dijkstra(){
        Queue<Maze> q = new ArrayDeque<>();
        q.add(new Maze(0,0,0));
        while(!q.isEmpty()){
            Maze now = q.poll();
            for(int i=0;i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx>=0&&ny>=0&&nx<N&&ny<M){
                    //벽돌이 없는경우
                    if(map[nx][ny]==0 && now.blocks<v[nx][ny]){
                        q.add(new Maze(nx,ny,now.blocks));
                        v[nx][ny] = now.blocks;
                    }
                    //벽돌이 있는경우 전보다 최단으로 왔으면 부수고 들어감
                    else if(map[nx][ny]==1 && now.blocks+1<v[nx][ny]){
                       q.add(new Maze(nx,ny, now.blocks+1));
                       v[nx][ny] = now.blocks+1;
                    }
                }
            }


        }
       return v[N-1][M-1];
    }


}
