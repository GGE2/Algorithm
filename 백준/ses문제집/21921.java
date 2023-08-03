import java.util.*;
import java.io.*;


class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] days = new int[N];


        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            days[i] = Integer.parseInt(st.nextToken());
        }

        int max = -1;
        int count = 1;
        int sum = 0;
        for(int i=0;i<N;i++){
            sum+=days[i];
            //처음 스타트
            if(i==X-1) max = sum;
            if(i>X-1){
                if(max<sum-days[i-X]){
                    max = sum-days[i-X];
                    count = 1;
                }else if(max==sum-days[i-X]) count++;
                sum-=days[i-X];
            }
        }
        if(max==0) System.out.println("SAD");
        else{
            System.out.println(max);
            System.out.println(count);
        }
    }


}
