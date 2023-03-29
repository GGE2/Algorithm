import java.util.*;


public class Main {

	public static void main(String[] args) {
		
		int[] num1;
		int[] num2;
		Scanner input=new Scanner(System.in);
		
		int num=input.nextInt();
			num1=new int[num];
			num2=new int[num];
			
		for(int i=0;i<num;i++)
		{
			
			num1[i]=input.nextInt();
			num2[i]=input.nextInt();
		}
		
		for(int i=0;i<num;i++)
		{
			System.out.println(num1[i]+num2[i]);
		}
		
	}
}
