

import java.io.*;
import java.util.*;


class Main{
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i=0;i<=N;i++) parent[i] = i;
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int now = Integer.parseInt(st.nextToken());
                if(now==1) {
                    union(i,j);
                    union(j,i);
                }

            }
        }
        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        boolean res  = true;
        for(int i=0;i<M-1;i++){
            if(start!=find(Integer.parseInt(st.nextToken()))){
                res = !res;
                break;
            }
        }
        System.out.println(res==true?"YES":"NO");
    }
    static void union(int x,int y){
        x = find(x);
        y = find(y);
        parent[x] = y;
    }
    static int find(int x){
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }
}
