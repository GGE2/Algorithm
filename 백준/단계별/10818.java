import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		int[] num;
		int size,min,max;
		
		size=input.nextInt();
		num=new int[size];
		
		for(int i=0;i<num.length;i++) {
			num[i]=input.nextInt();
			
		}
		min=num[0];
		max=num[0];
		
		for(int i=0;i<num.length;i++) {
			
			if(num[i]<min)
				min=num[i];
			if(num[i]>max)
				max=num[i];
		}
	
		System.out.println(min+" "+max);
		
	}
}
