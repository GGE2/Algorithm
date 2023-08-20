

import java.io.*;
import java.util.*;


class Main{


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N+1];

        for(int i=1;i<=N;i++)
            nums[i] = i;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int temp = nums[n1];
            nums[n1] = nums[n2];
            nums[n2] = temp;
        }
        for(int i=1;i<=N;i++)
            System.out.print(nums[i]+" ");
    }


}
