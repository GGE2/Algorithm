

import java.io.*;
import java.util.*;


class Main{
    static class Truck implements Comparable<Truck>{
        int weight;
        int time;
        int idx;
        boolean flag;
        public Truck(int weight,int time,int idx,boolean flag){
            this.weight = weight;
            this.time = time;
            this.idx = idx;
            this.flag = flag;
        }

        @Override
        public int compareTo(Truck o) {
            return this.idx-o.idx;
        }
    }

    static PriorityQueue<Truck> pq;
    static int time,n,w,l;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        time = 1;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int wt = Integer.parseInt(st.nextToken());
            pq.offer(new Truck(wt,w,i,false));
        }
        solution();
        System.out.println(time);
    }
    static void solution(){
        int bridge_weight = 0;
        Queue<Truck> q = new ArrayDeque<>();
        while(!pq.isEmpty()){
            while(!pq.isEmpty()&&pq.peek().weight+bridge_weight<=l){
                Truck now = pq.poll();
                bridge_weight+=now.weight;
                if(!now.flag) {
                    q.offer(new Truck(now.weight,now.time-1,now.idx,true));
                    break;
                }else{
                    q.offer(new Truck(now.weight,now.time-1,now.idx,true));
                }
            }
            while(!q.isEmpty()){
                Truck now = q.poll();
                if(now.time>0) pq.offer(new Truck(now.weight,now.time,now.idx,now.flag));
                bridge_weight-=now.weight;
            }
            time++;
        }
        return ;
    }


}

