import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		
		String[] dial= {"ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
		
		
		Scanner input=new Scanner(System.in);
		int cnt=0;
		String str=input.nextLine();
		String[] _str=null;
		String[] input_str=str.split("");
		
		
		for(int i=0;i<input_str.length;i++) {
			for(int j=0;j<dial.length;j++) {
				for(int k=0;k<dial[j].length();k++) {
					_str=dial[j].split("");
					if(_str[k].equals(input_str[i]))
						cnt=cnt+(j+1)+2;
				}
				
			}
			
		}
		
		
		System.out.println(cnt);
		
	}
}
