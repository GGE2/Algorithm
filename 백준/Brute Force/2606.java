import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    private static int N;
    private static int count=0;
    private static int[][] computers;
    private static boolean[] visited;
    private static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());

        computers = new int[N+1][N+1];
        visited = new boolean[N+1];
        Arrays.fill(visited,false);

        for(int i=1;i<=T;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            computers[x][y] = computers[y][x] = 1;
        }
        bfs(1);

        System.out.println(count);
    }
    private static void bfs(int start){
            queue.offer(start);
            visited[start] = true;

            while(!queue.isEmpty()){
                int now = queue.poll();
                for(int i=1;i<N+1;i++){
                    if(computers[now][i]==1&&visited[i]==false){
                        queue.offer(i);
                        visited[i]=true;
                        count++;
                    }
                }

            }
    }
}
