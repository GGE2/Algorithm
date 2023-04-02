import java.io.*;
import java.util.*;

public class BOJ {



    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        list.add(x);
        list.add(y);
        list.add(Math.abs(w-x));
        list.add(Math.abs(h-y));
        Collections.sort(list);
        System.out.println(list.get(0));

    }


}
