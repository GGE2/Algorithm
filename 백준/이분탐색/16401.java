

import java.io.*;
import java.util.*;


class Main{


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] snacks = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) snacks[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(snacks);
        int left = 1;
        int right = snacks[N-1];
        int answer = Integer.MIN_VALUE;

        while(left<=right){
            int mid = (left+right)/2;
            int count = 0;
            for(int i=0;i<N;i++) count+=snacks[i]/mid;
            if(count>=M) {
                if(answer<mid) answer = Math.max(answer,mid);
                left = mid+1;
            }
            else right = mid-1;
        }
        System.out.println(answer==Integer.MIN_VALUE?0:answer);
    }

    }

