
import java.util.*;
import java.io.*;

class Main {

    static class Node{
        int cost; //가중치
        int v;  //간선
        public Node(int cost,int v){
            this.cost = cost;
            this.v = v;
        }
    }
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dist;
    static int E,V,start;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];
        visited = new boolean[V+1];
        dist = new int[V+1];

        for(int i=1;i<=V;i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(w,v));
        }
        dijkstra(start);
        for(int i=1;i<=V;i++)
            System.out.println(dist[i]==Integer.MAX_VALUE?"INF":dist[i]);

    }
    static void dijkstra(int s){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
        pq.add(new Node(0,s));
        dist[s] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(!visited[now.v]){
                visited[now.v] = true;
            }
            for(Node next:graph[now.v]){
                if(!visited[next.v]&&dist[next.v]> now.cost+ next.cost){
                    dist[next.v] = now.cost+ next.cost;
                    pq.add(new Node(now.cost+next.cost,next.v));
                }

            }


        }

    }


}
