
import java.io.*;
import java.util.*;



class Main{

    static int[][] dp;
    static int[][] stickers;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            dp = new int[2][n+1];
            stickers = new int[2][n+1];

            for(int i=0;i<2;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1;j<=n;j++){
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for(int i=2;i<=n;i++){
                dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2]) + stickers[0][i];
                dp[1][i] = Math.max(dp[0][i-1],dp[0][i-2]) + stickers[1][i];
            }
            System.out.println(Math.max(dp[0][n],dp[1][n]));
        }
    }

}

