
import java.util.*;
import java.io.*;

class Main {

    static class Location{

        int loc;
        int time;

        public Location(int loc,int time){
            this.loc = loc;
            this.time = time;
        }

    }

    static int N,K;
    static int[] visited ;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001];

        for(int i=0;i<100001;i++)
            visited[i] = Integer.MAX_VALUE;

        bfs();


    }
    static void bfs(){
        Queue<Location> q = new ArrayDeque<>();
        q.add(new Location(N,1));
        visited[N] = 1;

        while(!q.isEmpty()){
            Location now = q.poll();
            if(now.loc-1>=0 && now.loc-1<=100000 && now.time+1<visited[now.loc-1]){//뒤로 갈경우
                visited[now.loc-1] = now.time+1;
                q.add(new Location(now.loc-1, now.time+1));
            }
            if(now.loc+1>=0 && now.loc+1<=100000 && now.time+1<visited[now.loc+1]){//앞으로 갈경우
                visited[now.loc+1] = now.time+1;
                q.add(new Location(now.loc+1,now.time+1));
            }
            if(now.loc*2>=0 && now.loc*2<=100000 && now.time<visited[now.loc*2]){ //순간이동
                visited[now.loc*2] = now.time;
                q.add(new Location(now.loc*2,now.time));
            }
        }
        System.out.println(visited[K]-1);

    }


}
