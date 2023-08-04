import java.util.*;
import java.io.*;


class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());


        int left = 0;
        int right = 0;

        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (left<=N && right <= N) {
            if(sum>=S && min>right-left) {
                min = right-left;
                if(min==1) break;
            }

            if(sum<S) sum+=nums[right++];
            else sum-=nums[left++];
        }
        if(min==Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(min);

    }
}
