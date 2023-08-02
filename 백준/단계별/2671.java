import java.util.*;
import java.io.*;


class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        if(str.matches("(100+1+|01)+"))
            System.out.println("SUBMARINE");
        else
            System.out.println("NOISE");



    }


}
