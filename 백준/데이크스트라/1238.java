

import java.io.*;
import java.util.*;


class Main{

    static class Node{
        int number;
        int cost;

        public Node(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }
    }

    static int N,M,X;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer>[] result = new ArrayList[2];
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0;i<=N;i++)
            graph[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end,cost));
        }

        for(int i=0;i<2;i++)
            result[i] = new ArrayList<>();

        for(int i=1;i<=N;i++){
            if(i==X) continue;
            result[0].add(dijkstra(i,X));
        }
        for(int i=1;i<=N;i++){
            if(i==X) continue;
            result[1].add(dijkstra(X,i));
        }

        int max = 0;
        for(int i=0;i<result[0].size();i++) max = Math.max(max,result[0].get(i)+result[1].get(i));
        System.out.println(max);
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.cost-o2.cost));
        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.fill(visited,false);
        dist[start] = 0;
        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(!visited[now.number]) visited[now.number] = true;
            for(Node next : graph[now.number]){
                if(!visited[next.number]&&dist[next.number]>dist[now.number]+next.cost){
                    dist[next.number] = dist[now.number]+next.cost;
                    pq.offer(new Node(next.number,dist[next.number]));
                }
            }
        }
        return dist[end];
    }


}
