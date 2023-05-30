
import java.util.*;
import java.io.*;

class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            int[] nums = new int[3];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<3;i++) nums[i] = Integer.parseInt(st.nextToken());

            if(nums[0]==0&&nums[1]==0&&nums[2]==0) break;
            Arrays.sort(nums);
            if(nums[2]>=nums[0]+nums[1]) System.out.println("Invalid");
            else if(nums[0]==nums[1]&&nums[1]==nums[2]) System.out.println("Equilateral");
            else if(nums[0]!=nums[1]&&nums[1]!=nums[2]&&nums[2]!=nums[0]) System.out.println("Scalene");
            else{
                int chk = 0;
                if(nums[0]==nums[1]) chk++;
                if(nums[0]==nums[2]) chk++;
                if(nums[1]==nums[2]) chk++;
                if(chk==1) System.out.println("Isosceles");
            }
        }

    }

}



