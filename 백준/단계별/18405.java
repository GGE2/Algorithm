

import java.io.*;
import java.util.*;


class Main{
    static class Virus implements Comparable<Virus>{
        int x;
        int y;
        int type;
        int time;

        public Virus(int x, int y, int type, int time) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.time = time;
        }

        @Override
        public int compareTo(Virus o) {
            if(this.time==o.time){
                return this.type-o.type;
            }else{
                return this.time-o.time;
            }
        }
    }
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int N,K;
    static int S,X,Y;
    static int[][] map;

    static PriorityQueue<Virus> q;
    static int[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[N][N];
        q = new PriorityQueue<>();

        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]!=0){
                    q.offer(new Virus(i,j,map[i][j],0));
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken())-1;
        Y = Integer.parseInt(st.nextToken())-1;
        bfs();
        System.out.println(visited[X][Y]);
    }
    static void bfs(){

        while(!q.isEmpty()){
            Virus now = q.poll();
            if(now.time>S) break;
            if(visited[now.x][now.y]==0)
                visited[now.x][now.y] = now.type;
            else
                continue;
            for(int i=0;i<4;i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(isRange(nx,ny)&&visited[nx][ny]==0&&map[nx][ny]==0){
                    q.add(new Virus(nx,ny,now.type,now.time+1));
                }
            }
        }
    }
    static boolean isRange(int x,int y){
        return x>=0&&y>=0&&x<N&&y<N;
    }
}
