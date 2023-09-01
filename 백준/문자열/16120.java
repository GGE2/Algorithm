

import java.io.*;
import java.util.*;


class Main{


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        int sLen = str.length();
        String answer = "PPAP";
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='P')
                stack.push(ch);
            else{//'A'
                if(stack.size()>=2&&i<sLen-1&&str.charAt(i+1)=='P'){
                    stack.pop();
                    stack.pop();
                }else{
                    System.out.println("NP");
                    return ;
                }
            }
        }
        if(stack.size()!=1) answer = "NP";
        bw.write(answer);
        br.close();
        bw.close();
    }

}
