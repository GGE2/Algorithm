

import java.io.*;
import java.util.*;


class Main{

    static int N;
    static int map[][];
    static int dp[][];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        dp = new int[N][N];
        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int res = dfs(i,j);
                max = Math.max(max,res);
            }
        }
        System.out.println(max);
    }
    static int dfs(int x,int y){
        //방문한 적이 있으면
        if(dp[x][y]!=-1) return dp[x][y];
        else{
            dp[x][y] = 1;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(isRange(nx,ny)&&map[x][y]<map[nx][ny]){
                    dp[x][y] = Math.max(dp[x][y],dfs(nx,ny)+1);
                }
            }
        }
        return dp[x][y];
    }
    static boolean isRange(int x,int y){
        return x>=0&&y>=0&&x<N&&y<N;
    }
}
