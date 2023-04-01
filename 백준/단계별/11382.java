import java.io.*;
import java.util.*;

public class BOJ {



    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long n1 = Long.parseLong(st.nextToken());
        Long n2 = Long.parseLong(st.nextToken());
        Long n3 = Long.parseLong(st.nextToken());

        System.out.println(n1+n2+n3);

    }


}
