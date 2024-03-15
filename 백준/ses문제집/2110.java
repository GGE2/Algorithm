

import java.io.*;
import java.util.*;



class Main{


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] houses = new int[N];
        for(int i=0;i<N;i++)
            houses[i] = Integer.parseInt(br.readLine());
        Arrays.sort(houses);

        int start = 1;
        int end = houses[N-1]-houses[0]+1;

        while(start<end){
            int mid = (end+start)/2;

            if(isInstalled(mid,houses)>=C) start = mid+1;
            else end = mid;

        }
        System.out.println(start-1);

    }
    static int isInstalled(int distance,int[] h){
        int count = 1;
        int lastInstalled = h[0];

        for(int i=1;i<h.length;i++){
            int now = h[i];
            if(now-lastInstalled>=distance){
                count++;
                lastInstalled = now;
            }
        }
        return count;
    }
}

