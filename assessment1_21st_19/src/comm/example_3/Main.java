package comm.example_3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	 static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
        String sentence;
		System.out.println("Enter the input String");
		sentence=sc.nextLine();
		TreeMap<Character, Integer> tMap= new TreeMap<Character, Integer>();
		
		LetterSequence ls= new LetterSequence(sentence);
		tMap=ls.computeFrequency();
		ls.displayLetterfrequency(tMap);
		
		
		
	}

}
