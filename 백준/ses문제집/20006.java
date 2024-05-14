import java.io.*;
import java.util.*;




class Main{

    static class Player{
        int level;
        String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }

    static ArrayList<ArrayList<Player>> rooms;
    static ArrayList<Integer> v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        rooms = new ArrayList<>();
        v = new ArrayList<>();

        while(p-->0){
            st = new StringTokenizer(br.readLine());
            int lv = Integer.parseInt(st.nextToken());
            String nm = st.nextToken();
            //방 전체가 비어 있는 경우
            if(rooms.size()==0){
                ArrayList<Player> list = new ArrayList<>();
                list.add(new Player(lv,nm));
                rooms.add(list);
                v.add(1);
               // System.out.println("방이 아무것도 없어서 새로 만듬");
            }else{
                boolean flag = false;
                for(int i=0;i<v.size();i++){
                    int now = rooms.get(i).get(0).level;
                    //이미 풀방인경우
                    if(v.get(i)==m) continue;
                    //방에 들어갈 수 있는 경우
                    else if(lv>=now-10&&lv<=now+10){
                        rooms.get(i).add(new Player(lv,nm));
                        v.set(i,v.get(i)+1);
                        flag = true;
                       // System.out.println(i+"번방들어감 방주인 레벨 : "+now+" 내 레벨 : "+lv);
                        break;

                    }
                }
                //들어갈 방이 없는 경우
                if(!flag){
                    ArrayList<Player> list = new ArrayList<>();
                    list.add(new Player(lv,nm));
                    rooms.add(list);
                    v.add(1);
                    //System.out.println("들어갈 방이 아무것도 없어서 새로 만듬");
                }
            }
        }
        for(int i=0;i<rooms.size();i++){
            Collections.sort(rooms.get(i),((o1, o2) -> {
                return o1.name.compareTo(o2.name);
            }));
        }

        for(int i=0;i<v.size();i++){
            if(v.get(i)==m){
                System.out.println("Started!");
            }
            else{
                System.out.println("Waiting!");
            }
            for(int j=0;j<rooms.get(i).size();j++)
                System.out.println(rooms.get(i).get(j).level+" "+rooms.get(i).get(j).name);

        }

    }

}

