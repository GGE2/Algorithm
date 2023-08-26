

import java.io.*;
import java.util.*;


class Main{

    static int N,M;
    static char[][] map;
    static int[][] dp;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static int max;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        max = Integer.MIN_VALUE;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                dp[i][j] = -1;
            }
        }
        visited[0][0] = true;
        dfs(0,0,1);
        if(flag){
            System.out.println(-1);
        }else{
            System.out.println(max);
        }
    }
    static void dfs(int x,int y,int cnt){
        if(max<cnt)
            max = cnt;
        dp[x][y] = cnt;

        for(int i=0;i<4;i++){
            int nx = x+(dx[i]*(map[x][y]-'0'));
            int ny = y+(dy[i]*(map[x][y]-'0'));

            //맵을 벗어나거나 구멍을 만나는 경우
            if(nx<0 || ny<0 || nx>=N || ny>=M || map[nx][ny]=='H') continue;

            //사이클인 경우
            if(visited[nx][ny]){
                flag = true;
                return ;
            }
            if(dp[nx][ny]>cnt) continue;
            visited[nx][ny] = true;
            dfs(nx,ny,cnt+1);
            visited[nx][ny] = false;
        }

    }


}
