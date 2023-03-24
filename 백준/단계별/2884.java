import java.util.*;
public class Main {

	public static void main(String[] args) {
	
		Scanner scanner=new Scanner(System.in);
		
		
		
		int h=scanner.nextInt();
		int m=scanner.nextInt();
		int sum=0;
		
		sum=60*h+m-45;
		int H=sum/60;
		int M=sum-H*60;
		
		if(h==0&&m<45)
		{
			H=23;
			System.out.println(+H+" "+(60-Math.abs(M)));
			return ;
		}
			
		
		System.out.println(+H+" "+M);
	}

}
