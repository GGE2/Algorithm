

import java.io.*;
import java.util.*;


class Main{

    static int count,cnt;
    static int[] dp;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        count = 0;
        cnt = 0;
        fibo(N);
        fibonacci(N);
        System.out.println(count+" "+cnt);
    }
    static int fibo(int N){
        if(N==1||N==2){
            count++;
            return 1;
        }
        else return fibo(N-1)+fibo(N-2);
    }
    static void fibonacci(int N){
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3;i<=N;i++){
            cnt++;
            dp[i] = dp[i-1] + dp[i-2];
        }
    }
}
