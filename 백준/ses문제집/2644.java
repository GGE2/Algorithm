
import java.util.*;
import java.io.*;

class Main {

    static int N,n1,n2;
    static int[][] relation;
    static boolean[] visited;
    static int res = -1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());
        int input = Integer.parseInt(br.readLine());
        relation = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0;i<input;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relation[a][b] = 1;
            relation[b][a] = 1;
        }

        dfs(0,n1,n2);
        System.out.println(res);
    }
    static void dfs(int degree,int now,int target){
        visited[now] = true;
        for(int i=1;i<relation.length;i++){
            if(relation[now][i]==1&&!visited[i]) {
                if(i==target){
                    res = degree+1;
                    return ;
                }
                dfs(degree + 1, i, target);
            }
        }
        return ;
    }

}





