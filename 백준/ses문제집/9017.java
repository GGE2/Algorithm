import java.io.*;
import java.util.*;




class Main{



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //주자 수, 팀 순위, 5번쨰 순위
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            int result = -1;
            int[] s = new int[N+1];
            int[] m = new int[N+1];
            int[][] score = new int[N+1][3];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++) {
                int player = Integer.parseInt(st.nextToken());
                m[i] = player;
                s[player]++;
            }
            int rank = 1;
            for(int i=1;i<=N;i++){
                if(s[m[i]]!=6) continue;
                score[m[i]][0]++;
                if(score[m[i]][0]<5) score[m[i]][1]+=rank;
                if(score[m[i]][0]==5) score[m[i]][2] = rank;
                rank++;
            }
            for(int i=1;i<=N;i++){
                if(score[i][0]!=6||min<score[i][1]) continue;
                else if(min>score[i][1]){
                    min = score[i][1];
                    result = i;
                }
                else{
                    if(score[result][2]>score[i][2]){
                        min = score[i][1];
                        result = i;
                    }
                }
            }
            System.out.println(result);
        }


    }

}

