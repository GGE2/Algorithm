

import java.io.*;
import java.util.*;



class Main{

    static int N,L,R,answer;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<ArrayList<Point>> list;
    static ArrayList<Point> curList;
    static class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        answer = 0;
        map = new int[N][N];
        visited = new boolean[N][N];
        list = new ArrayList<ArrayList<Point>>();
        curList = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean flag = true;
        while(true){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    for(int k=0;k<4;k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(isRange(nx,ny)&&!visited[nx][ny]&&Math.abs(map[i][j]-map[nx][ny])>=L&&Math.abs(map[i][j]-map[nx][ny])<=R){
                            dfs(i,j);
                            list.add(curList);
                            curList = new ArrayList<>();
                        }
                    }
                }
            }
            if(list.size()==0) break;
            else {
                answer++;
                movePopulation();
                list = new ArrayList<>();
                curList = new ArrayList<>();
                visited = new boolean[N][N];
            }
        }
        System.out.println(answer);
    }
    static void dfs(int nowX,int nowY){
        visited[nowX][nowY] = true;
        curList.add(new Point(nowX,nowY));
        for(int i=0;i<4;i++){
            int nx = nowX+dx[i];
            int ny=  nowY+dy[i];
            if(isRange(nx,ny)&&Math.abs(map[nowX][nowY]-map[nx][ny])>=L&&Math.abs(map[nowX][nowY]-map[nx][ny])<=R&&!visited[nx][ny]){
                dfs(nx,ny);
            }
        }
        return ;
    }
    static boolean isRange(int x,int y){
        if(x<0||y<0||x>=N||y>=N) return false;
        return true;
    }
    static void movePopulation(){
        for(int i=0;i<list.size();i++){
            int sum= 0;
            for(Point point : list.get(i))
                sum += map[point.x][point.y];
            for(Point point : list.get(i))
                map[point.x][point.y] = sum/list.get(i).size();
        }
    }

}

