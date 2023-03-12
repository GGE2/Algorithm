/**
문제별로 visited[]를 통해 continue 조절 확인! , 시간차이 무지막지!

**/


import java.util.*;
import java.io.*;

class Main{
    static class Node{
        int v;
        int cost;
        public Node(int v,int cost){
            this.v = v;
            this.cost = cost;
        }
    }
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] cost;
    static int N,M,dep,des;



    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        cost = new int[N+1];
        visited = new boolean[N+1];

        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
            cost[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[n].add(new Node(b,c));
        }
        st = new StringTokenizer(br.readLine());
        dep = Integer.parseInt(st.nextToken());
        des = Integer.parseInt(st.nextToken());

        dijkstra(dep);

        System.out.println(cost[des]);


    }
    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.v]) continue;
            visited[now.v] = true;

            for(Node next:graph[now.v]){
                if(cost[next.v]>now.cost + next.cost){
                    cost[next.v] = now.cost+ next.cost;
                    pq.add(new Node(next.v, cost[next.v]));
                }
            }


        }


    }


}


