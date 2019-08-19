package comm.example.excr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Deck {
	private static List<Card> protoDeck= new ArrayList<Card>();
	static {
		for(Suit s:Suit.values()) {
			for(Rank r:Rank.values()) {
				protoDeck.add(new Card(s,r));
			}
		}
		System.out.println(protoDeck);
		
		
	}
	
	public void distributeCards(int h, int noc) {
	    		for(int i=0;i<h;i++) {
			
			System.out.println("****for "+i+" hand, cards are....*****");
			
			for(int j=0; j<noc;j++) {
				Collections.shuffle(protoDeck);
				System.out.println(protoDeck.get(j));
				
			}
		}
	}
	
	public static void main(String args[]) {
		Deck d=new Deck();
		int hands,noOfCards;
		String str="y";
		Scanner sc=new Scanner(System.in);
		do {
			if(str=="y") {
		System.out.println("numbers of hands: ");
		hands=sc.nextInt();
		System.out.println("numbers of cards per hand: ");
		noOfCards=sc.nextInt();
		d.distributeCards(hands,noOfCards);
		System.out.println("TO CONTINUE press (y/n)");
		str=sc.nextLine();
		}
			else if (str=="n"){
				System.exit(1);
		}
		else {
				System.out.println("please enter valid char");
		}
		
		}
		while(str=="y");
	}
}
