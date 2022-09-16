package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_요리사{
    static int[][] foods;
    static boolean[] v;
    static int N;
    static int min;
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/in.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=TC;tc++){
            N = Integer.parseInt(br.readLine());
            foods = new int[N][N];
            v = new boolean[N];
            min=Integer.MAX_VALUE;
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    foods[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            solve(0,0);
            sb.append("#").append(tc).append(" ").append(min).append("\n");

        }
        System.out.println(sb);
        br.close();

    }
    static void solve(int depth,int start){ //음식을 n/2개로 나누는 경우의 조합
        if(depth==N/2){
            calc();
            return ;
        }

        for(int i=start;i<N;i++){
            v[i] = true;
            solve(depth+1,i+1);
            v[i] = false;
        }

    }
    static void calc() {
        int as=0;
        int bs=0;

        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(v[i]&&v[j])as+=foods[i][j]+foods[j][i];
                else if(!v[i]&&!v[j])bs+=foods[i][j]+foods[j][i];
            }
        }
        int m = Math.abs(as-bs);
        min = Math.min(min,m);
    }

}
