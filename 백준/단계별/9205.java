
import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

class Main {
    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static int T,N;
    static ArrayList<Point> points;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            points = new ArrayList<>();
            graph = new ArrayList<>();
            for(int i=0;i<N+2;i++){
                st = new StringTokenizer(br.readLine());
                points.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }
            for(int i=0;i<N+2;i++){
                graph.add(new ArrayList<>());
            }
            for(int i=0;i<graph.size();i++){
                for(int j=i+1;j<graph.size();j++){
                    if(distance(points.get(i),points.get(j))){
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }
            if(bfs()) System.out.println("happy");
            else System.out.println("sad");
        }

    }
    static boolean bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        boolean[] visited = new boolean[N+2];
        while(!q.isEmpty()){
            int now = q.poll();
            visited[now] = true;
            if(now==N+1){
                return true;
            }
            for(int node : graph.get(now)){
                if(!visited[node]) {
                    q.add(node);
                    visited[node] = true;
                }
            }
        }
        return false;
    }
    static boolean distance(Point p1,Point p2){
        if(Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y)<=1000) return true;
        else return false;
    }


}
class Person{
    int x;
    int y;
    int m;
    int beer;

    public Person(int x, int y, int m, int beer) {
        this.x = x;
        this.y = y;
        this.m = m;
        this.beer = beer;
    }
}





