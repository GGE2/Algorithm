import java.io.*;
import java.util.*;


class Main {
    static class Node{
        int x;
        int y;
        int cnt;

        //0: 안부심 , 1: 부심
        int isCrashing;

        public Node(int x, int y, int cnt, int isCrashing) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.isCrashing = isCrashing;
        }
    }
    static int min;

    static int N,M;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static boolean[][][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        map = new int[N][M];
        visited = new boolean[2][N][M];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++)
                map[i][j] = str.charAt(j)-'0';
        }
        bfs();
        System.out.println(min==Integer.MAX_VALUE?-1:min);
    }
    static void bfs(){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0,0,1,0));

        while(!q.isEmpty()){

            Node now = q.poll();
            if(now.x==N-1&&now.y==M-1){
                min = now.cnt;
                break;
            }
            for(int i=0;i<4;i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(isRange(nx,ny)){
                    //벽이 아닐떄 방문한 적이 없다면
                    if(map[nx][ny]==0){
                        if(!visited[now.isCrashing][nx][ny]){
                            q.offer(new Node(nx,ny, now.cnt+1,now.isCrashing));
                            visited[now.isCrashing][nx][ny] = true;
                        }
                    }else{
                    //벽일때는 벽을 한번도 안부순 경우만
                        if(!visited[now.isCrashing][nx][ny]&&now.isCrashing==0){
                            q.offer(new Node(nx,ny,now.cnt+1,1));
                            visited[now.isCrashing][nx][ny] = true;
                        }
                    }
                }
            }
        }

    }
    static boolean isRange(int x,int y){
        return x>=0&&y>=0&&x<N&&y<M;
    }


}
