
import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

class Main {
    static class Tomato{
        int x;
        int y;
        int day;
        public Tomato(int x,int y,int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] boxes;
    static int tDay = Integer.MIN_VALUE;
    static int M,N;
    static ArrayList<Tomato> arr;
    static int zeroc=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        boxes = new int[N][M];
        int zero = 0;
        arr = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int box = Integer.parseInt(st.nextToken());
                boxes[i][j] = box;
                if(box==0) zero++;
                else if(box==1) arr.add(new Tomato(i,j,0));
            }
        }
        if(zero==0){ //익지 않은 토마토가 없는 경우 0
            System.out.println(0);
        }else{
            bfs();
            if(zero!=zeroc) System.out.println(-1);
            else System.out.println(tDay);
        }




    }
    static void bfs(){
        Queue<Tomato> q  = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        for(int i=0;i<arr.size();i++){
            q.add(new Tomato(arr.get(i).x,arr.get(i).y,0));
            visited[arr.get(i).x][arr.get(i).y] = true;
        }
        while(!q.isEmpty()){
            Tomato now = q.poll();
            if(now.day > tDay) tDay = now.day;

            for(int i=0;i<4;i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(isRange(nx,ny)&&boxes[nx][ny]!=-1&&!visited[nx][ny]){
                    q.add(new Tomato(nx,ny,now.day+1));
                    visited[nx][ny] = true;
                    if(boxes[nx][ny]==0) zeroc++;
                }
            }

        }
    }
    static boolean isRange(int x,int y){
        if(x>=0&&y>=0&&x<N&&y<M) return true;
        else return false;
    }

}





