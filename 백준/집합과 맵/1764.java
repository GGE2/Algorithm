

import java.io.*;
import java.util.*;


class Main{



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            String str = br.readLine();
            map.put(str,1);
        }
        for(int i=0;i<M;i++){
            String str = br.readLine();
            if(map.containsKey(str))
                list.add(str);
        }
        System.out.println(list.size());
        Collections.sort(list);
        for(String str : list)
            System.out.println(str);
    }


}
