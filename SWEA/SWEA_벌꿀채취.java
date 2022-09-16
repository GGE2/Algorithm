package SWEA;

import java.util.*;
import java.io.*;



public class SWEA_벌꿀채취{
    public static void main(String[] args)throws Exception {
        //System.setIn(new FileInputStream("res/in.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st=new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            collect = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n-m+1; j++) {
                    int temp =calMax(i,j,0,0,0);
                    collect.add(new int[] {i, j, temp});
                }
            }

            Collections.sort(collect, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[2]-o1[2];
                }
            });

            int max=0, len = Math.min(m*2-1, n-m+1);
            for (int i = 0; i < len; i++) {
                int[] fst = collect.get(i);
                for (int j = i+1; j < collect.size(); j++) {
                    int[] snd = collect.get(j);
                    if(fst[0]==snd[0] && Math.abs(fst[1]-snd[1])<m)continue;

                    if(max<fst[2]+snd[2]) {
                        max=fst[2]+snd[2]; break;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static int n,m,c;
    static int[][]map;
    static ArrayList<int[]>collect;

    static int calMax(int i,int j, int cost, int wid, int cnt) {
        if(wid>c)return 0;
        if(cnt==m) {
            return cost;
        }
        int temp=0;
        temp = calMax(i,j+1, cost+map[i][j]*map[i][j], wid + map[i][j], cnt+1);
        temp = Math.max(temp, calMax(i,j+1, cost, wid, cnt+1));
        return temp;
    }


}