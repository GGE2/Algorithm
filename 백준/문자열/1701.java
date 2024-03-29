import java.io.*;
import java.util.*;


class Main {

    static int[] table;
    static int max = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String str = br.readLine();


        for(int i=0;i<str.length();i++){
            max = Math.max(max,search(str.substring(i,str.length())));
        }
        System.out.println(max);
    }
    static int search(String str){
        int sLen = str.length();
        table = new int[sLen];
        int index = 0;
        int m = 0;
        for(int i=1;i<sLen;i++){
            while(index>0&&str.charAt(i)!=str.charAt(index)){
                index = table[index-1];
            }
            if(str.charAt(i)==str.charAt(index)){
                table[i] = ++index;
                m = Math.max(m,index);
            }
        }
        return m;
    }

}
