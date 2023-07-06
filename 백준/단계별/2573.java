
import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

class Main {
    static class Iceburg{
        int x;
        int y;
        int height;

        int count;
        public Iceburg(int x, int y, int height,int count) {
            this.x = x;
            this.y = y;
            this.height = height;
            this.count = count;
        }
    }

    static int N,M;
    static int[][] iceburgs;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int fy=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        iceburgs = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int ice = Integer.parseInt(st.nextToken());
                iceburgs[i][j] = ice;
            }
        }
        bfs();
        if(fy!=0) System.out.println(fy);
        else System.out.println(0);
    }
    static void bfs(){
        Queue<Iceburg> q = new ArrayDeque<>();
        Queue<Iceburg> temp = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(iceburgs[i][j]!=0) q.add(new Iceburg(i,j,iceburgs[i][j],0));
            }
        }
        int next = 1;
        while(!q.isEmpty()){
            Iceburg now = q.poll();
            if(now.count==next){ //한 사이클을 돌고난 후 첫번쨰 -> 배열에 반영
                if(arrangeArr(temp)){
                    fy = now.count;
                    break;
                }
                else{
                    temp.clear();
                    ++next;
                }
            }
            if(now.height==0) continue;
            int zeroCount = 0;
            for(int i=0;i<4;i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(isRange(nx,ny)){//상하좌우 0
                    zeroCount++;
                }
            }
            if (zeroCount >= now.height){//높이가 0이 되는경우
                q.add(new Iceburg(now.x, now.y, 0, now.count + 1));
                temp.add(new Iceburg(now.x, now.y, 0, now.count + 1));
            }
            else { //높이가 0이 아닌경우
                q.add(new Iceburg(now.x, now.y, now.height - zeroCount, now.count + 1));
                temp.add(new Iceburg(now.x, now.y, now.height - zeroCount, now.count + 1));
            }

        }

    }
    static boolean arrangeArr(Queue<Iceburg> tq){
        while(!tq.isEmpty()){
            Iceburg ib = tq.poll();
            //System.out.println(ib.x+" "+ib.y+" "+ ib.height+" "+ib.count);
            iceburgs[ib.x][ib.y] = ib.height;
        }
        /*for(int i=0;i<N;i++)
            System.out.println(Arrays.toString(iceburgs[i]));*/

        boolean res = isDivided();
        if(res) return true;
        else return false;
    }
    static boolean isRange(int x,int y){
        if (x>=0&&y>=0&&x<N&&y<M&&iceburgs[x][y]==0) return true;
        else return false;
    }
    static boolean isDivided(){
        int[][] clone = new int[N][M];
        for(int i=0;i<iceburgs.length;i++)
            clone[i] = iceburgs[i].clone();

        int count =0;
        for(int i=0;i<clone.length;i++){
            for(int j=0;j<clone[i].length;j++){
                if(clone[i][j]!=0){
                    if(dfs(i,j,clone)){
                        count++;
                    }
                }
            }
            if(count>1){
                break;
            }
        }
        if(count>1) return true;
        else return false;
    }
    static boolean dfs(int x,int y,int[][] clone){
        clone[x][y] = 0;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0&&ny>=0&&nx<N&&ny<M&&clone[nx][ny]!=0){
                dfs(nx,ny,clone);
            }
        }
        return true;
    }

}





