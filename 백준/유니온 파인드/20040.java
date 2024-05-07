
import java.io.*;
import java.util.*;



class Main{

    static int n,m;
    static int[] parent;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;
        int answer = 0;

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if(!union(n1,n2)){
                answer = i+1;
                break;
            }
        }
        System.out.println(answer);

    }
    static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    static boolean union(int from,int to){
        int x = find(from);
        int y = find(to);
        if(x!=y){
            parent[x] = y;
            return true;
        }
        return false;
    }



}

