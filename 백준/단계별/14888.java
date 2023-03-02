import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] nums;
    static int[] op;
    static int min,max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        op = new int[4];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            nums[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++)
            op[i] = Integer.parseInt(st.nextToken());
        bt(0,nums[0]);
        System.out.println(max);
        System.out.println(min);
    }
    static void bt(int count,int sum){
        if(count==N-1){
            min = Math.min(sum,min);
            max = Math.max(sum,max);
            return ;
        }

        for(int i=0;i<4;i++){
            if(op[i]==0) continue;
            op[i]--;
            bt(count+1,cal(count,i,sum));
            op[i]++;
        }

    }
    static int cal(int index,int op,int sum){
        int res =0;
        switch (op){
            case 0 : {
                res = sum+nums[index+1];
                break;
            }
            case 1:{
                res = sum-nums[index+1];
                break;
            }
            case 2:{
                res = sum*nums[index+1];
                break;
            }
            case 3:{
                res = sum/nums[index+1];
                break;
            }


        }
        return res;
    }

}
