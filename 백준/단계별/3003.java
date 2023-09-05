

import java.io.*;
import java.util.*;


class Main{


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] chess = new int[6];

        for(int i=0;i<6;i++){
            chess[i] = Integer.parseInt(st.nextToken());
            int c = chess[i];
            switch (i){
                case 0 :
                case 1 : {
                    if(c==1){
                        System.out.print(0+" ");
                    }else{
                        System.out.print(1-c+" ");
                    }
                    break;
                }
                case 2 :
                case 3 :
                case 4:{
                    if(c==2){
                        System.out.print(0+" ");
                    }else{
                        System.out.print(2-c+" ");
                    }
                    break;
                }
                case 5:{
                    if(c==8){
                        System.out.print(0+" ");
                    }else{
                        System.out.print(8-c+" ");
                    }
                    break;
                }
            }
        }
    }

}
