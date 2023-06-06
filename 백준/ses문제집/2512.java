
import java.util.*;
import java.io.*;

class Main {

    static int N,limit;
    static int[] budgets;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int sum=0;

        N = Integer.parseInt(br.readLine());
        budgets = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            sum+=budgets[i];
        }
        limit = Integer.parseInt(br.readLine());
        Arrays.sort(budgets);
        //예산의 총합이 limit보다 작거나 같은 경우
        if(sum<=limit) System.out.println(budgets[N-1]);
        //예산의 총합이 limit보다 큰 경우
        else{
            int avg = sum/N;
            int s = 0;
            for(int i=0;i<N;i++){
                if(budgets[i]<avg) s+=budgets[i];
                else s+=avg;
            }
            if(s<limit){
                while(s<limit){
                    s=0;
                    for(int i=0;i<N;i++){
                        if(budgets[i]<avg) s+=budgets[i];
                        else s+=avg;
                    }
                    avg++;
                }
                System.out.println(avg-1);
            }else if(s>limit){
                while(s>limit){
                    s=0;
                    for(int i=0;i<N;i++){
                        if(budgets[i]<avg) s+=budgets[i];
                        else s+=avg;
                    }
                    avg--;
                }
                System.out.println(avg+1);
            }else{
                System.out.println(avg);
            }
        }

    }

}



