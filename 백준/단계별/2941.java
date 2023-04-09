import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str2 = "aaaa";
        String[] strings = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        String read = br.readLine();
        int count = 0;

        for(String str:strings){
            if(read.contains(str)==true) {
                read = read.replace(str,"_");
            }
        }
        count=read.length();

        System.out.println(count);







    }

}
