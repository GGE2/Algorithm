import java.io.*;
import java.util.*;



class Main {
    static class Node{
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    static int[] parent;
    static int N,M;
    static int[][] computers;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        computers = new int[M][3];

        for(int i=1;i<=N;i++) parent[i] = i;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            computers[i][0] = Integer.parseInt(st.nextToken());
            computers[i][1] = Integer.parseInt(st.nextToken());
            computers[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(computers,(Comparator.comparingInt(o -> o[2])));

        int answer = 0;
        for(int[] com : computers){
            if(union(com[0],com[1])){
                answer+=com[2];
            }
        }
        System.out.println(answer);

    }
    static int find(int x){
        //리프 노드
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    static boolean union(int from,int to){
        int x = find(from);
        int y = find(to);
        if(x!=y){ //연결 안된경우
            parent[x] = y;
            return true;
        }
        return false;
    }


}
