import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)==Math.abs(o2)){
                    return o1>o2?1:-1;
                }else{
                    return Math.abs(o1)-Math.abs(o2);
                }
            }
        });
        for(int i=0;i<N;i++){
            int input = Integer.parseInt(br.readLine());
            if(input==0){
                if(pq.size()==0){
                    System.out.println(0);
                }else{
                    System.out.println(pq.poll());
                }
            }else{
                pq.offer(input);
            }
        }




    }
}
