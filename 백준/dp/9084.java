

import java.io.*;
import java.util.*;


class Main{

    static int[] dp;
    static int[] coins;
    static int price;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        while(TC-->0){
            int N = Integer.parseInt(br.readLine());
            coins = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++)
                coins[i] = Integer.parseInt(st.nextToken());
            price = Integer.parseInt(br.readLine());
            dp = new int[price+1];

            dp[0] = 1;
            for(int i=1;i<=N;i++){
                for(int j=coins[i];j<=price;j++)
                    dp[j]+= dp[j-coins[i]];
            }
            System.out.println(dp[price]);
        }




    }


}
