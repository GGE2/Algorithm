import java.util.*;
import java.io.*;

public class SWEA_1949_등산로조성 {
    static int N,K;
    static int[][] map;
    static boolean[][] v;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int max;
    static int cnt;
    static ArrayList<Point> tops;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=TC;tc++){
            tops = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            max = Integer.MIN_VALUE;
            int max_value=0;
            map = new int[N][N];
            v = new boolean[N][N];

            for(int i=0;i<N;i++){
                Arrays.fill(v[i],false);
            }
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]>max_value)
                        max_value = map[i][j];
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j]==max_value){
                        tops.add(new Point(i,j));
                    }
                }
            }
            for(int i=0;i<tops.size();i++){
                v[tops.get(i).x][tops.get(i).y] = true;
                hikingTrail(1,true,tops.get(i).x,tops.get(i).y,map,v);
                v[tops.get(i).x][tops.get(i).y] = false;
                //System.out.println(cnt);
            }

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
    static void hikingTrail(int count,boolean isMow,int x,int y,int[][] new_map,boolean[][] visited){
        int c = count;
        boolean b = isMow;
        int now_x = x;
        int now_y = y;
        int[][] now_map = new_map;
        for(int i=0;i<4;i++){
            int nx = now_x+dx[i];
            int ny = now_y+dy[i];
            if(isMapRange(nx,ny)&&!visited[nx][ny]){//map의 범위안에 있는경우
                if(now_map[now_x][now_y]>now_map[nx][ny]){//이동이 가능한경우
                    visited[nx][ny] = true;
                    hikingTrail(c+1,isMow,nx,ny,now_map,visited);
                    visited[nx][ny] = false;
                }else{
                    if(b){ //깎지 않은경우
                        if(now_map[now_x][now_y]>now_map[nx][ny]-K){ //깎으면 이동이 가능한 경우
                            int[][] cm = changeMap(now_x,now_y,nx,ny,now_map);
                            visited[nx][ny] = true;
                            hikingTrail(c+1,false,nx,ny,cm,visited);
                            visited[nx][ny] = false;
                        }else{ //깎아도 이동이 불가능한 경우
                            max = Math.max(max,c);
                        }

                    }
                    else{ //이미 깎은 경우
                        max = Math.max(max,c);
                    }
                }


            }else{ //map 범위를 벘어난 경우
                max = Math.max(max,c);
            }


        }


    }
    static boolean isMapRange(int x,int y){
        if(x>=0&&x<N&&y>=0&&y<N)
            return true;
        return false;
    }
    static int[][] changeMap(int x,int y,int nx,int ny,int[][] maps){
        int[][] m=new int[N][N];

        for(int i=0;i<N;i++){
            m[i] = maps[i].clone();
        }

        m[nx][ny] = m[x][y]-1;
        return m;
    }

}
class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}

