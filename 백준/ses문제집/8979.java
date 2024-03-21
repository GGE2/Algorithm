
import java.io.*;
import java.util.*;



class Main{
    static int countOrder = 0;
    static class Medal implements Comparable<Medal>{
        int idx;
        int rank;
        int gold;
        int silver;
        int bronze;
        public Medal(int idx,int rank,int gold, int silver, int bronze) {
            this.idx = idx;
            this.rank = rank;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Medal o) {
            if(this.gold==o.gold){
                if(this.silver==o.silver){
                    if(this.bronze==o.bronze){
                        return 0;
                    }
                    else{
                        return -(this.bronze-o.bronze);
                    }
                }else{
                    return -(this.silver-o.silver);
                }
            }else{
                return -(this.gold-o.gold);
            }
        }
    }
    static ArrayList<Medal> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int ps = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Medal(ps,0,g,s,b));
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            if(i==0){
                list.get(i).rank = 1;
                countOrder++;
            }else{
                Medal before = list.get(i-1);
                Medal now = list.get(i);
                if(before.gold==now.gold&&before.silver==now.silver&&before.bronze==now.bronze){
                    list.get(i).rank = list.get(i-1).rank;
                    countOrder++;
                }else{
                    list.get(i).rank = countOrder+1;
                    countOrder++;
                }
            }
        }
        for(Medal medal : list){
            if(medal.idx==K){
                System.out.println(medal.rank);
                break;
            }
        }
    }
}

