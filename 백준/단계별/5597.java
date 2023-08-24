

import java.io.*;
import java.util.*;


class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[31];

        for(int i=0;i<28;i++){
            int n = Integer.parseInt(br.readLine());
            nums[n] = 1;
        }
        for(int i=1;i<=30;i++)
            if(nums[i]==0) System.out.println(i);

    }

}
