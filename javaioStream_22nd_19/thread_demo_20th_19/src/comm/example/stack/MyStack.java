package comm.example.stack;

public class MyStack {

	private int index = -1;
	private static final int MAX=7;
	private char[] info=new char[MAX];
	
	public synchronized void push(char item) throws InterruptedException{
		if(index==MAX) {
			System.out.println("Stack overflow");
			System.out.println("Producer Waiting");
			wait();
		}
		info[++index]=item;
		System.out.println("customer notified");
		notify();
	}
	
	public synchronized int pop() throws InterruptedException{
		if(index==-1) {
			System.out.println("stack underflow");
			System.out.println("consumer waiting");
			wait();
		}
		System.out.println("producer notified");
		notify();
		return info[index--];
	}
}
