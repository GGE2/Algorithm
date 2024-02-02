import java.io.*;
import java.util.*;


class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());

        while(T.toString().length()!=S.length()){
            int len = T.length();
            if(T.charAt(len-1)=='A'){
                T.deleteCharAt(len-1);
            }else{
                T.deleteCharAt(len-1);
                T.reverse();
            }
        }
        System.out.println(S.equals(T.toString())?1:0);
    }

}

