

import java.io.*;
import java.util.*;


class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String str = br.readLine();
        int n = str.length();
        char first = str.charAt(0);
        boolean flag=  true;
        if(isPalindrome(str)){
            for(int i=0;i<n;i++){
                if(first!=str.charAt(i)){
                    flag = false;
                    break;
                }
            }
            System.out.println(flag?-1:n-1);
        }else{
            System.out.println(n);
        }

    }
    static boolean isPalindrome(String pattern){
        StringBuilder sb = new StringBuilder(pattern);
        if(sb.reverse().toString().equals(pattern)) return true;
        return false;
    }

}

