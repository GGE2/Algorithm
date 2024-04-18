
import java.io.*;
import java.util.*;



class Main{

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] years = new int[3];
        int[] nYear = new int[3];
        int answer = 0;
        for (int i = 0; i < 3; i++) years[i] = Integer.parseInt(st.nextToken());

        while(true){
            answer++;
            nYear[0]++;
            nYear[1]++;
            nYear[2]++;

            if(nYear[0]>15) nYear[0] = 1;
            if(nYear[1]>28) nYear[1] = 1;
            if(nYear[2]>19) nYear[2] = 1;

            if(nYear[0]==years[0]&&nYear[1]==years[1]&&nYear[2]==years[2]) break;


        }
        System.out.println(answer);
    }

}

