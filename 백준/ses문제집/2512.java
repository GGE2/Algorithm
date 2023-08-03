import java.util.*;
import java.io.*;


class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] budgets = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = 0, end =-1;
        for(int i=0;i<N;i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end,budgets[i]);
        }
        int total = Integer.parseInt(br.readLine());
        Arrays.sort(budgets);




        while(start<=end){
            int mid = (start+end) / 2;
            int sum = 0;
            for(int i=0;i<N;i++){
                if(budgets[i]<=mid) sum+=budgets[i];
                else sum+=mid;
            }
            if(sum<=total) start = mid+1;
            else end = mid-1;
        }

        System.out.println(end);
    }


}
