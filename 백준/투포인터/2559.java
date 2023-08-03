import java.util.*;
import java.io.*;


class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        int to = 0;
        for(int i=0;i<N;i++)
        {
            nums[i] = Integer.parseInt(st.nextToken());
            to+= nums[i];
        }
        int start = 0;
        int end = -1;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        if(N==K){
            System.out.println(to);
        }else{
            while(true){
                if(++end==N) break;
                sum+=nums[end];
                if(end-start==K-1){
                    max = Math.max(sum,max);
                    sum-=nums[start];
                    start++;
                }
            }
            System.out.println(max);
        }

    }


}
