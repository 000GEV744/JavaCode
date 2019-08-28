package comm.example;

import java.util.Vector;

public class Producer implements Runnable {

	private final Vector<Integer> sharedQueue;
	private final int SIZE;
	
	
	
	public Producer(Vector<Integer> sharedQueue, int sIZE) {
		super();
		this.sharedQueue = sharedQueue;
		SIZE = sIZE;
	}
	
	
	@Override
	public void run() {
			try {
				for(int i=0;i<7;i++) {
					System.out.println("produce: "+i);
					produce(i);
				}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}		
	}
	
	private synchronized void produce(int i) throws InterruptedException{
		//wait if queue is full
		if(sharedQueue.size()==SIZE) {
			System.out.println("Queue is Full "+Thread.currentThread().getName()+" is waiting, size: "+sharedQueue.size());
			wait();
		}
		sharedQueue.add(i);
	    notifyAll();
	}

}
