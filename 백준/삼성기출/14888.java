import java.util.*;
import java.io.*;

class Main {

    static int N, min, max;
    static int[] op, nums;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        op = new int[4];
        nums = new int[N];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            op[i] = Integer.parseInt(st.nextToken());
        calc(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void calc(int depth, int sum) {
        if (depth == N) {
            if (sum < min)
                min = sum;
            if (sum > max)
                max = sum;

            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                calc(depth+1,operation(sum,depth,i));
                op[i]++;
            }
        }
    }

    static int operation(int sum, int index, int o) {
        int res = 0;
        switch (o) {
            case 0: {
                res = sum + nums[index];
                break;
            }
            case 1: {
                res = sum - nums[index];
                break;
            }
            case 2: {
                res = sum * nums[index];
                break;
            }
            case 3: {
                res = sum/nums[index];
                break;
            }

        }
        return res;

    }
}
