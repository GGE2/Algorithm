import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		int[] num=new int[10];
		int[] rem=new int[42];
		int cnt=0;
		int res=0;
		for(int i=0;i<10;i++)
			num[i]=input.nextInt();
		
		for(int i=0;i<10;i++)
			rem[num[i]%42]++;
		
			
		for(int i=0;i<42;i++)
		{
			if(rem[i]!=0)
				cnt++;
		}
		
		System.out.println(cnt);
		
	}
	
}
