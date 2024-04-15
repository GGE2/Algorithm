
import java.io.*;
import java.util.*;



class Main{

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> sets = new HashSet<>();
        int N = Integer.parseInt(st.nextToken());
        char sign = st.nextToken().charAt(0);

        for (int i = 0; i < N; i++) {
            sets.add(br.readLine());
        }
        switch (sign){
            case 'Y':{
                System.out.println(sets.size());
                break;
            }
            case 'F':{
                System.out.println(sets.size()/2);
                break;
            }
            case 'O':{
                System.out.println(sets.size()/3);
                break;
            }


        }

    }

}

