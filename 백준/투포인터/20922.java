import java.util.*;
import java.io.*;


class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        int[] number = new int[100001];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) nums[i]=Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int count = 0;
        while(right<N){
            number[nums[right]]++;
            //K개 초과일때
            if(number[nums[right]]>K){
                max = Math.max(max,count);
                while(number[nums[left]]!=number[nums[right]]){
                    number[nums[left]]--;
                    count--;
                    left++;
                }
                //찾고 다음인덱스로 넘김
                number[nums[left]]--;
                left++;
                right++;
            }
            else{
                right++;
                count++;
            }

        }
        max = Math.max(max,count);
        System.out.println(max);


    }


}
