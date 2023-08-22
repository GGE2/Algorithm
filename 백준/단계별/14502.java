

import java.io.*;
import java.util.*;


class Main{
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static boolean[] visited;
    static boolean[][] v;
    static Node[] nodes;
    static int[][] map;
    static int max;
    static int check_count;
    static boolean[][] vi;

    static int N,M;
    static ArrayList<Node> pick;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<Node> before;
    static int count=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        nodes = new Node[N*M];
        max = Integer.MIN_VALUE;
        pick = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0)
                    pick.add(new Node(i,j));
            }
        }
        visited = new boolean[pick.size()];
        v = new boolean[N][M];
        comb(0,0,new int[3],map);
        System.out.println(max);
    }
    static void comb(int start,int depth,int[] com,int m[][]){
        if(depth==3){
            before = new ArrayList<>();
            count = 0;
            //뽑힌 경우 map 바꿔줌
            vi = new boolean[N][M];
            for(int i=0;i<3;i++){
                Node now = pick.get(com[i]);
                m[now.x][now.y] = 1;
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(m[i][j]==2&&!vi[i][j]) {
                        dfs1(i,j,m);
                    }
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(m[i][j]==0&&!vi[i][j]){
                        check_count = 0;
                        dfs2(i,j,m);
                        count+=check_count;
                    }
                }
            }
            for(int i=0;i<3;i++){
                Node now = pick.get(com[i]);
                m[now.x][now.y] = 0;
            }
            max = Math.max(max,count);
            return ;
        }
        for(int i=start;i<pick.size();i++){
            if(visited[i]) continue;
            visited[i] = true;
            com[depth] = i;
            comb(i+1,depth+1,com,m);
            visited[i] = false;
        }
    }
    static void dfs1(int x,int y,int[][] m){
        vi[x][y] = true;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(isRange(nx,ny)&&!vi[nx][ny]&&m[nx][ny]!=1){
                vi[nx][ny] = true;
                dfs1(nx,ny,m);
            }
        }
    }

    static void dfs2(int x,int y,int[][] mp){
        vi[x][y] = true;
        check_count++;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(isRange(nx,ny)&&!vi[nx][ny]){
                if(mp[nx][ny]==0){
                    vi[nx][ny] = true;
                    dfs2(nx,ny,mp);
                }
            }
        }

    }
    static boolean isRange(int x,int y){
        return x>=0&&y>=0&&x<N&&y<M;
    }
}
