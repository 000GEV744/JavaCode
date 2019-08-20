package comm.example;

import java.util.Vector;

public class ProducerConsumerSolution {

	public static void main(String[] args) {
		Vector<Integer> sharedQueue = new Vector<Integer>();
		int size=4;
		Thread prodThread=new Thread(new Producer(sharedQueue,size),"Producer");//inside the String we are passing the name of our constructor 
		//so that when we do getName(), we get Producer as the name of the thread.
		Thread consThread=new Thread(new Consumer(sharedQueue,size),"Consumer");
		prodThread.start();
		consThread.start();
		
	}
}
