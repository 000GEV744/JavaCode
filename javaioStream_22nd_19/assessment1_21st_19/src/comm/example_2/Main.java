package comm.example_2;
import java.util.Scanner;
public class Main {
 static Scanner sc=new Scanner(System.in);
 static boolean result;
	public static void main(String[] args) {
		
		Main.input();
		Main.output(result);	
	}
	public static void input() {
		System.out.println("enter password: ");
		String password=sc.next();
		result=UserMainCode.checkPassword(password);
		
	}
	public static void output(boolean result) {
		if(result==true) {
			System.out.println("valid password");
		}
		else System.out.println("invalid password");
	}
}
