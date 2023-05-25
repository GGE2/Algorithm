import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;


public class Main {

    static char[][] cookies;
    static int[] heart = new int[2];
    static int[] bodies = new int[5];
    static int h;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cookies = new char[N][N];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                cookies[i][j] = str.charAt(j);
            }
        }

        //심장 찾기 , 상하좌우 * 인경우
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(cookies[i][j]=='*'){
                    if(isFlag(i,j,N)&&cookies[i-1][j]=='*'&&cookies[i][j+1]=='*'&&cookies[i+1][j]=='*'&&cookies[i][j-1]=='*'){
                        heart[0] = i;
                        heart[1] = j ;
                        break;
                    }
                }
            }
        }
        // 찾고나서 왼쪽팔,오른쪽팔,허리,왼쪽다리,오른쪽다리
        for(int i=heart[1]-1;i>=0;i--){
            if(cookies[heart[0]][i]=='*') bodies[0]++;
            else break;
        }
        for(int i=heart[1]+1;i<N;i++) {
            if (cookies[heart[0]][i] == '*') bodies[1]++;
            else break;
        }
        for(int i=heart[0]+1;i<N;i++){
            if (cookies[i][heart[1]] == '*') bodies[2]++;
            else{
                h=i;
                break;
            }
        }
        int i=h;
        int j=heart[1]-1;
        while(i<N){
            if(cookies[i][j]=='*'){
                bodies[3]++;
                i++;
            }else break;
        }
        i=h;
        j=heart[1]+1;
        while(i<N&&j<N){
            if(cookies[i][j]=='*'){
                bodies[4]++;
                i++;
            }else break;
        }
        System.out.println((heart[0]+1)+" "+(heart[1]+1));
        for(int k=0;k<5;k++)
            if(k==4) System.out.print(bodies[k]);
            else System.out.print(bodies[k]+" ");
    }
    static boolean isFlag(int x,int y,int N){
        if(x-1>=0&&y+1<N&&x+1<N&&y-1>=0) return true;
        else return false;

    }
}
