
import java.io.*;
import java.util.*;




class Main{
    static class Node implements Comparable<Node>{
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node n1){
            return this.weight-n1.weight;
        }
    }

    static int n,m,r;
    static int[] dist;
    static int[] items;
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int answer = Integer.MIN_VALUE;
        items = new int[n+1];
        graph = new ArrayList[n+1];

        for(int i=1;i<=n;i++) graph[i] = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) items[i] = Integer.parseInt(st.nextToken());

        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to,weight));
            graph[to].add(new Node(from,weight));
        }

        for(int i=1;i<=n;i++){
            int total = 0;
            dist = new int[n+1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dijkstra(i);
            for(int j=1;j<=n;j++){
                if(dist[j]<=m) total+=items[j];
            }
            answer = Math.max(answer,total);
        }
        System.out.println(answer);
    }
    static void dijkstra(int startPoint){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startPoint,0));
        dist[startPoint] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            for(Node next : graph[now.end]){
                if(dist[next.end]>next.weight+dist[now.end]) {
                    dist[next.end] = next.weight+dist[now.end];
                    pq.offer(new Node(next.end, next.weight));
                }
            }
        }
        return ;
    }


}

