import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
			Scanner input=new Scanner(System.in);
			
			String str=input.next();
			
			for(char a='a';a<='z';a++)
				System.out.print(str.indexOf(a)+" ");
				
	}

}
