package comm.example_3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

	 static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
        String sentence;
		System.out.println("Enter the input String");
		sentence=sc.nextLine();
		System.out.println(sentence);
		char[] c=sentence.replaceAll(" ", "").toCharArray();
		for(char ch:c) {
			System.out.print(ch);
		}
		System.out.println(InetAddress.getLocalHost());
	}

}
