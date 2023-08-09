

import java.io.*;
import java.util.*;


class Main{

    static class Node{
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    static boolean[][] visited;
    static int[][] map;
    static int[][] dist;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        dist = new int[N][N];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            for(int j=0;j<N;j++)
                map[i][j] = str.charAt(j)-'0';
        }
        dijkstra();
        bw.write(dist[N-1][N-1]+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
    static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        pq.offer(new Node(0,0,0));
        dist[0][0] = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(!visited[now.x][now.y]) visited[now.x][now.y] = true;

            for(int i=0;i<4;i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(isRange(nx,ny)){
                    int next = (map[nx][ny]==1)?0:1;
                    if(!visited[nx][ny]&&dist[nx][ny]>dist[now.x][now.y]+next){
                        dist[nx][ny] = dist[now.x][now.y]+next;
                        pq.offer(new Node(nx,ny,dist[nx][ny]));
                    }
                }

            }

        }

    }
    static boolean isRange(int x,int y){
        if(x>=0&&y>=0&&x<N&&y<N) return true;
        else return false;
    }



}
