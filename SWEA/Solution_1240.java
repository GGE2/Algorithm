import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution_1240{

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        String[] str = {"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
        for(int c=1;c<=tc;c++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char[][] codes= new char[n][m];
            int checkI=0;
            int checkJ=0;
            for(int i=0;i<n;i++){
                String in = br.readLine();
                for(int j=0;j<m;j++){
                    codes[i][j] = in.charAt(j);
                    if(codes[i][j] == '1') {
                        checkI = i;
                        checkJ = j;
                    }
                }
            }

            List<Integer> list  = new ArrayList<>();
            for(int i=checkJ;i>checkJ-56;i=i-7){
                String check="";
                for(int j=i-6;j<=i;j++){
                    check+=codes[checkI][j];
                }
                for(int k=0;k<str.length;k++){
                    if(check.equals(str[k])){
                        list.add(k);
                    }
                }
            }

//            for(int i=0;i<80;i++){
//                String check="";
//                for(int j=i;j<i+7;j++){
//                    check+=codes[checkIndex][j];
//                }
//                for(int k=0;k<str.length;k++){
//                    if(check.equals(str[k])){
//                        res[resIndex] = k;
//                        count++;
//                        resIndex++;
//                        i=i+6;
//                    }
//                }
//                if(count==8) break;
//            }
            Collections.reverse(list);
            int odd=0;
            int even=0;
            int result=0;
            for(int i=0;i<8;i++){
                result+=list.get(i);
                if(i%2==0){
                    even+=list.get(i);
                }else odd+=list.get(i);
            }
            int sum = 0 ;
            sum = odd+(even*3);
            if(sum%10!=0) result = 0;


            sb.append("#").append(c).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
        br.close();



    }







}
