import java.io.*;
import java.util.*;




class Main{

    static class Point{
        int num;
        double x;
        double y;

        public Point(int num, double x, double y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    static class Node implements Comparable<Node>{
        int from;
        int to;
        double distance;

        public Node(int from, int to, double distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if(distance<o.distance) return -1;
            return 1;
        }
    }
    static int[] parent;
    static Point[] points;
    static ArrayList<Node> nodes;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        points = new Point[n+1];
        nodes = new ArrayList<>();
        StringTokenizer st;

        for(int i=1;i<=n;i++){
            st  = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            points[i] = new Point(i,x,y);
        }
        for(int i=1;i<=n;i++) parent[i] = i;

        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                nodes.add(new Node(i,j,getDistance(points[i],points[j])));
            }
        }
        Collections.sort(nodes);

        double answer = 0.0;
        for(Node node : nodes){
            if(union(node.from, node.to)) answer+= node.distance;
        }
        System.out.println(answer);


    }
    static double getDistance(Point p1,Point p2){
        return Math.sqrt(Math.pow(p1.x-p2.x,2)+Math.pow(p1.y-p2.y,2));
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

