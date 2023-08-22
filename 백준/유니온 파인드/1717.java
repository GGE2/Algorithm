

import java.io.*;
import java.util.*;


class Main{
    static int[] parent;
    static int n,m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i=0;i<=n;i++) parent[i] = i;
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(flag==0){ //합집합
                union(start,end);
            }else{
                if(find(start)==find(end)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }

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
