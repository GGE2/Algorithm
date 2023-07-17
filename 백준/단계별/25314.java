import java.io.*;
import java.util.*;

public class BOJ {


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = "";
        for(int i=0;i<N/4;i++)
            str +="long ";
        System.out.println(str+"int");
        }

}
