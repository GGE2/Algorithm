import java.util.*;
import java.io.*;


class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int total = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int res=0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            res += p*n;
        }
        if(res==total) System.out.println("Yes");
        else System.out.println("No");
    }

}

