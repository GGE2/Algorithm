import java.util.*;
import java.io.*;


class Main {

    static int[][] honeycomb;
    static int M, N;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        honeycomb = new int[M][M];



        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int zero = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            grow_hc(zero, one, two);
        }
        for(int i=1;i<M;i++){
            for(int j=1;j<M;j++){
                honeycomb[i][j] = Math.max(Math.max(honeycomb[i-1][j-1],honeycomb[i][j-1]),honeycomb[i-1][j]);
            }
        }
        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                if(j==M-1) sb.append(honeycomb[i][j]+1);
                else sb.append(honeycomb[i][j]+1).append(" ");
            }
            if(i!=M-1)sb.append("\n");
        }
        System.out.print(sb);
    }

    // 좌측 하단 ~ 우측 상단 벌집 변환
    static void grow_hc(int zero, int one, int two) {
        for (int i = M-1; i >=0; i--) {
            if(zero!=0) {
                zero--;
            }else if(one!=0) {
                honeycomb[i][0] += 1;
                one--;
            }else if(two!=0) {
                honeycomb[i][0] += 2;
                two--;
            }
        }
        for (int i = 1; i < M; i++) {
            if(zero!=0) {
                zero--;
            }else if(one!=0) {
                honeycomb[0][i] += 1;
                one--;
            }else if(two!=0) {
                honeycomb[0][i] += 2;
                two--;
            }
        }
    }

}
