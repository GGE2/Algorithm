import java.io.*;
import java.util.*;

public class BOJ {



    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int plus = Integer.parseInt(br.readLine());
        int hr = (H*60+M+plus)/60;
        int mr = (H*60+M+plus)%60;

        H =(hr>23)?hr-24:hr;
        M = mr;
        System.out.println(H+" "+M);
    }


}
