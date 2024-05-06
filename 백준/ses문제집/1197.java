
import java.io.*;
import java.util.*;



class Main{

    static int V,E;
    static int[] parent;
    static int[][] graph;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        graph = new int[E][3];

        for(int i=1;i<=V;i++) parent[i] = i;

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(graph,(o1,o2)->{
           return o1[2]-o2[2];
        });

        long answer = 0;

        for(int[] g : graph){
            if(union(g[0],g[1])){
                answer+=g[2];
            }
        }
        System.out.println(answer);
    }

    private static boolean union(int from, int to) {
        int x = find(from);
        int y = find(to);

        if(x!=y){
            parent[x] = y;
            return true;
        }

        return false;
    }

    private static int find(int x) {
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }


}

