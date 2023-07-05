import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

class Main {
    static class Tomato implements Comparable<Tomato>{
        int z;
        int x;
        int y;
        int days;

        public Tomato(int z,int x, int y,int days) {
            this.z = z;
            this.x = x;
            this.y = y;
            this.days = days;
        }

        @Override
        public int compareTo(Tomato o) {
            return 0;
        }
    }
    static class Ripe{
        int h;
        int x;
        int y;
        public Ripe(int h,int x,int y){
            this.h = h;
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Ripe> ripes;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int M,N,H;
    static int[][][] boxes;
    static int top = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        boxes = new int[H][N][M];
        ripes = new ArrayList<>();
        int zero = 0;
        for(int k=0;k<H;k++){
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    int num = Integer.parseInt(st.nextToken());
                    boxes[k][i][j] = num;
                    if(num==0) zero++;
                    else if(num==1){
                        ripes.add(new Ripe(k,i,j));
                    }
                }
            }
        }
        if(zero==0) System.out.println(0);
        else{
            bfs();
            boolean flag = false;
            for(int k=0;k<H;k++){
                for(int i=0;i<N;i++){
                    for(int j=0;j<M;j++){
                        if(boxes[k][i][j]==0){
                            flag = true;
                            break;
                        }
                    }
                    if(flag) break;
                }
                if(flag) break;
            }
            if(flag) System.out.println(-1);
            else System.out.println(top);
        }

    }
    static void bfs(){
        Queue<Tomato> q = new ArrayDeque<>();
        int[][][] visited = new int[H][N][M];
        for(int i=0;i<ripes.size();i++){
            Ripe ripe = ripes.get(i);
            q.add(new Tomato(ripe.h,ripe.x,ripe.y,0));
            visited[ripe.h][ripe.x][ripe.y] = 0;
        }
        for(int z=0;z<H;z++){
            for(int i=0;i<N;i++){
                Arrays.fill(visited[z][i],Integer.MAX_VALUE);
            }
        }
        while(!q.isEmpty()){
            Tomato now = q.poll();
            if(now.days>top) top = now.days;
            for(int i=0;i<4;i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(isRange(nx,ny)&&(boxes[now.z][nx][ny]==0||boxes[now.z][nx][ny]==1)&&now.days+1<visited[now.z][nx][ny]){
                    boxes[now.z][nx][ny]=1;
                    q.add(new Tomato(now.z,nx,ny,now.days+1));
                    visited[now.z][nx][ny] = now.days+1;
                }
            }
            if(now.z-1>=0&&(boxes[now.z-1][now.x][now.y]==0||boxes[now.z-1][now.x][now.y]==1)&&now.days+1<visited[now.z-1][now.x][now.y]){
                boxes[now.z-1][now.x][now.y]=1;
                q.add(new Tomato(now.z-1,now.x,now.y,now.days+1));
                visited[now.z-1][now.x][now.y] = now.days+1;
            }
            if(now.z+1<H&&(boxes[now.z+1][now.x][now.y]==0||boxes[now.z+1][now.x][now.y]==1)&&now.days+1<visited[now.z+1][now.x][now.y]){
                boxes[now.z+1][now.x][now.y]=1;
                q.add(new Tomato(now.z+1,now.x,now.y,now.days+1));
                visited[now.z+1][now.x][now.y] = now.days+1;
            }
            
        }
    }
    static boolean isRange(int x,int y){
        if(x>=0&&y>=0&&x<N&&y<M) return true;
        else return false;
    }


}
