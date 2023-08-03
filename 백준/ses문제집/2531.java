import java.util.*;
import java.io.*;


class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());


        int[] sushi = new int[N];
        int[] eated = new int[d+1];

        int count = 0;
        for(int i=0;i<N;i++){
            sushi[i] = Integer.parseInt(br.readLine())-1;
        }
        for(int i=0;i<k;i++)
            if(eated[sushi[i]]++==0) count++;

        int answer = 0;
        for(int i=0;i<N;i++){
            if(answer<=count) {
                if(eated[c-1]==0) answer = count+1;
                else answer = count;
                if(answer==k+1) break;
            }
            int end = (i+k)%N;
            if(eated[sushi[end]]++==0) count++;
            if(--eated[sushi[i]]==0) count--;
        }

        System.out.println(answer);
    }


}
