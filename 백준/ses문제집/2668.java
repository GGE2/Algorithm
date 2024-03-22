
import java.io.*;
import java.util.*;



class Main{

    static int[] nums;
    static int N;
    static boolean[] visited;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
        visited = new boolean[N+1];
        list = new ArrayList<>();

        for(int i=1;i<=N;i++) nums[i] = Integer.parseInt(br.readLine());

        for(int i=1;i<=N;i++){
            visited[i] = true;
            dfs(i,i);
            visited[i] = false;
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int n : list)
            System.out.println(n);
    }
    static void dfs(int start,int end){
        if(!visited[nums[end]]){
            visited[nums[end]] = true;
            dfs(start,nums[end]);
            visited[nums[end]] = false;
        }
        if(start==nums[end]) list.add(end);

    }

}

