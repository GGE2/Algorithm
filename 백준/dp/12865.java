

import java.io.*;
import java.util.*;


class Main{

    static int[][] dp;
    static int[][] bags;
    static int N,K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bags = new int[N+1][2];
        dp = new int[N+1][K+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            bags[i][0] = Integer.parseInt(st.nextToken());
            bags[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=K;j++){
                if(bags[i][0]<=j){
                    if(dp[i-1][j-bags[i][0]]+bags[i][1]>dp[i-1][j])
                        dp[i][j] = dp[i-1][j-bags[i][0]] + bags[i][1];
                    else
                        dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        System.out.println(dp[N][K]);

    }


}
