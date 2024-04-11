
import java.io.*;
import java.util.*;



class Main{

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int answer = 1;

        while(A!=B){

            if(B<A) {
                System.out.println(-1);
                return;
            }
            String str = String.valueOf(B);
            //2를 나눌수 있는 경우
            if(B%2==0){
                B = B/2;
            }
            else if(str.charAt(str.length()-1)=='1'){
                str = str.substring(0,str.length()-1);
                B = Integer.parseInt(str);
            }else{
                System.out.println(-1);
                return ;
            }
            answer++;
        }
        System.out.println(answer);
    }

}

