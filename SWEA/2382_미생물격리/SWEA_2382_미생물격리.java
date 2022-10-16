import java.util.*;
import java.io.*;

public class SWEA_2382_미생물격리 {
    static int N,M,K;
    static int[] dx = {0,-1,1,0,0}; //상하좌우
    static int[] dy = {0,0,0,-1,1};
    static int time;
    static int res;
    static int c;
    static ArrayList<Micro>[][] micro;
    static Queue<Micro> q;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=TC;tc++){
            time = 0;
            res = 0;
            q = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            micro = new ArrayList[N][N];

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    micro[i][j] = new ArrayList<>();
                }
            }

            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                int moving = Integer.parseInt(st.nextToken());
                micro[x][y].add(new Micro(x,y,count,moving,false));
                q.add(new Micro(x,y,count,moving,false));
            }
            move();
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.println(sb);


    }
    static void move(){

        while(time<M) {
            c++;
            while (!q.isEmpty()) {
                Micro now = q.poll();
                int x = now.x;
                int y = now.y;
                int count = now.count;
                boolean hap = now.hap;
                int dir = now.dir;
                int nx = x + dx[dir];
                int ny = y + dy[dir];


                if (isRange(nx, ny)) { //이동했는데 테두리가 아닌경우
                    micro[x][y].remove(0); //원래 있던 자리를 비워준다
                    micro[nx][ny].add(new Micro(nx, ny, count, dir, hap)); //좌표 이동
                } else { //이동했는데 테두리로 간경우
                    micro[x][y].remove(0); //원래 있던 자리를 비워준다
                    switch(dir){
                        case 1:{
                            dir = 2;
                            break;
                        }
                        case 2:{
                            dir = 1;
                            break;
                        }
                        case 3:{
                            dir = 4;
                            break;
                        }
                        case 4:{
                            dir = 3;
                            break;
                        }
                    }
                    if(count!=1) { //count==1일경우 삭제
                        micro[nx][ny].add(new Micro(nx, ny, count / 2, dir, hap));
                    }
                }

            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(micro[i][j].size()==1){
                        Micro m = micro[i][j].get(0);
                        q.add(new Micro(m.x,m.y,m.count,m.dir,m.hap)); //큐에 다시 넣어주기
                    }
                    if (micro[i][j].size() > 1) { //이동헀는데 미생물이 여러개 있는 경우
                        int max = 0; //미생물 최대값
                        int idx = 0;
                        int sum = 0;
                        for (int k = 0; k < micro[i][j].size(); k++) {
                            sum += micro[i][j].get(k).count;
                            if (max < micro[i][j].get(k).count) { //그 셀의 가장 큰 값의 index
                                max = micro[i][j].get(k).count;
                                idx = k;
                            }
                        }
                        int moving = micro[i][j].get(idx).dir;
                        micro[i][j].clear();
                        micro[i][j].add(new Micro(i, j, sum, moving, false)); //미생물 합치기
                        q.add(new Micro(i, j, sum, moving, false));//큐에 다시 넣어주기
                    }
                }
            }

            time++;

        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(micro[i][j].size()!=0){
                    for(int k=0;k<micro[i][j].size();k++){
                        res+=micro[i][j].get(k).count;
                    }
                }
            }
        }

    }
    static boolean isRange(int x,int y){

        if(x>=1&&y>=1&&x<N-1&&y<N-1)
            return true;
        return false;
    }


}
class Micro{
    int x;
    int y;
    int count;
    int dir;
    boolean hap;
    public Micro(int x,int y,int count,int dir,boolean hap){
        this.x = x;
        this.y = y;
        this.count = count;
        this.dir = dir;
        this.hap = hap;
    }

}
