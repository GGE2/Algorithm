import java.util.*;
import java.io.*;


class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());


        if(N==1) System.out.println(1);
        else{
            int answer = 1;
            int num = 1;
            while(true){
                num = num+(6*answer);
                if(N<=num) break;
                answer++;
            }
            System.out.println(++answer);
        }

    }


}
