import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

class Main {
    static class Floor{
        int f;
        int count;
        public Floor(int f,int count){
            this.f = f;
            this.count = count;
        }
    }
    static int[] ev;
    static int F,S,G,U,D;
    static int[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        ev = new int[F+1];
        visited = new int[F+1];
        Arrays.fill(visited,Integer.MAX_VALUE);
        bfs();
        int res = (visited[G]==Integer.MAX_VALUE)?-1:visited[G];
        if(res==-1)
            System.out.println("use the stairs");
        else System.out.println(res);
    }
    static void bfs(){
        Queue<Floor> q = new ArrayDeque<>();
        q.add(new Floor(S,0));
        visited[S] = 0;
        while(!q.isEmpty()){
            Floor now = q.poll();
            int up = now.f+U;
            int down = now.f-D;
            if(up<=F&&up!=now.f&&visited[up]>now.count+1){
                q.add(new Floor(up, now.count+1));
                visited[up] = now.count+1;
            }
            if(down>=1&&down!=now.f&&visited[down]>now.count+1){
                q.add(new Floor(down,now.count+1));
                visited[down] = now.count+1;
            }
        }
    }

}
