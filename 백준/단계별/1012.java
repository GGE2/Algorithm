import java.util.*;
import java.io.*;

class Main {

    static int T;
    static int[] M,N,K;
    static int[][][] cabbages;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int count;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        M = new int[T];
        N = new int[T];
        K = new int[T];

        cabbages = new int[T][50][50];

        for(int k=0;k<T;k++){
            st = new StringTokenizer(br.readLine());
            M[k] = Integer.parseInt(st.nextToken());
            N[k] = Integer.parseInt(st.nextToken());
            K[k] = Integer.parseInt(st.nextToken());
            for(int i=0;i<K[k];i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbages[k][x][y] = 1;
            }

        }
        for(int k=0;k<T;k++){
            count=0;
            for(int i=0;i<M[k];i++){
                for(int j=0;j<N[k];j++){
                    if(cabbages[k][i][j]==1&&dfs(k,i,j)){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }
    static boolean dfs(int t,int x,int y){
        if(cabbages[t][x][y]==0){
            return false;
        }
        cabbages[t][x][y] = 0;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0&&ny>=0&&nx<50&&ny<50&&cabbages[t][nx][ny]==1){
                dfs(t,nx,ny);
            }
        }
        return true;
    }


}
