

import java.io.*;
import java.util.*;


class Main{


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;
        int[] arr = new int[N];

        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int left = 0;
        int right = 0;
        while(left<=right&&right<N){
            int minus = arr[right]-arr[left];
            if(minus>=M){
                answer = Math.min(minus,answer);
                left++;
                if(answer==M) break;
            }else{
                right++;
            }
        }
        System.out.println(answer);


    }

    }

