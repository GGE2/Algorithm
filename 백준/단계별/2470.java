import java.time.LocalDate;
import java.util.*;
import java.io.*;

class Main {


    static int[] soluttions;


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        soluttions = new int[N];

        for(int i=0;i<N;i++)
            soluttions[i] = Integer.parseInt(st.nextToken());


        Arrays.sort(soluttions);

        int start = 0;
        int end = N-1;
        int min = Integer.MAX_VALUE;
        int n1 = -1;
        int n2 = -1;
        while(start<end){
            int res = soluttions[end] + soluttions[start];
            if(res==0){
                System.out.println(soluttions[start]+" "+soluttions[end]);
                System.exit(0);
            }
            if(Math.abs(res)<min) {
                min = Math.abs(res);
                n1 = soluttions[start];
                n2 = soluttions[end];
            }
            if(res<0){
                start++;
            }else
                end--;


        }
        System.out.println(n1+" "+n2);

    }


}
