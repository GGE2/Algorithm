
import java.util.*;
import java.io.*;

class Main {




    static int W,H;

    static int[][] maps;
    static int cnt;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if(W==0&&H==0) return ;

            maps = new int[H][W];

            for(int i=0;i<H;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<W;j++)
                    maps[i][j] = Integer.parseInt(st.nextToken());
            }

            cnt = 0;

            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    if(dfs(i,j))
                        cnt++;
                }
            }
            System.out.println(cnt);
        }




    }
    static boolean dfs(int x , int y){
        if(maps[x][y]==0) return false;
        maps[x][y] = 0;

        for(int i=0;i<8;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0&&ny>=0&&nx<H&&ny<W&&maps[nx][ny]==1){
                dfs(nx,ny);
            }
        }
        return true;
    }


}
