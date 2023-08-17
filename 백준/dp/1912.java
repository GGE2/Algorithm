

import java.io.*;
import java.util.*;


class Main{


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            nums[i] = Integer.parseInt(st.nextToken());

        dp[0] = nums[0];
        int max = nums[0];
        for(int i=1;i<N;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);

    }

}
