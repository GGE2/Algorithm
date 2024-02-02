

import java.io.*;
import java.util.*;


class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1000];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[Integer.parseInt(st.nextToken())]++;
        }
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1;i<=999;i++){
            if(arr[i]==1) list.add(i);
            else if(arr[i]>=2){
                list.add(i);
                list.add(i);
            }
        }
        int answer = 0;
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                int num = list.get(i) * list.get(j);
                int sum = 0;
                while(num>0){
                    sum+=num%10;
                    num/=10;
                }
                answer = Math.max(sum,answer);
            }
        }
        System.out.println(answer);
    }


}

