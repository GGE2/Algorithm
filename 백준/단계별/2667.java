import java.time.LocalDate;
import java.util.*;
import java.io.*;

class Main {


    static int[][] ap;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<Integer> apart;
    static int count;
    static int N;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ap = new int[N][N];
        apart = new ArrayList<>();

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                ap[i][j] = str.charAt(j)-'0';
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(ap[i][j]==1){
                    count =0;
                    dfs(i,j);
                    apart.add(count);
                }
            }
        }
        Collections.sort(apart);
        System.out.println(apart.size());
        for(int i=0;i<apart.size();i++)
            System.out.println(apart.get(i));
    }
    static void dfs(int x,int y){

        if(ap[x][y]==1) {
            count++;
            ap[x][y] = 0;
        }
        for(int i=0;i<4;i++){
            int nx = dx[i]+x;
            int ny = dy[i]+y;
            if(nx>=0&&ny>=0&&nx<N&&ny<N&&ap[nx][ny]==1){
                dfs(nx,ny);
            }
        }


    }


}2
