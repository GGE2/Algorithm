import java.util.*;
import java.io.*;


class Main {
    static class Node implements Comparable<Node>{
        int start;
        int cost;

        public Node(int start, int cost) {
            this.start = start;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }
    static int[] dist;
    static boolean[] visited;
    static ArrayList<Node>[] graph;
    static int N,D;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dist = new int[D+1];
        graph = new ArrayList[D+1];
        visited = new boolean[D+1];
        for(int i=0;i<=D;i++){
            graph[i] = new ArrayList<>();
            graph[i].add(new Node(i+1,1));
        }
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());
            if(n1>D||n2>D) continue;
            graph[n1].add(new Node(n2,n3));
        }
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        dijkstra(0);

        System.out.println(dist[D]);
    }
    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){

            Node now = pq.poll();
            if(now.start>D) continue;
            if(!visited[now.start]) visited[now.start] = true;

            for(Node next : graph[now.start]){
                if(next.start<=D&&!visited[next.start]&&dist[next.start]>dist[now.start]+ next.cost) {
                    dist[next.start] = dist[now.start] + next.cost;
                    pq.add(new Node(next.start, dist[now.start] + next.cost));
                }
            }


        }

    }
}
