package comm.example.stack;

public class StackProducer implements Runnable{

	private MyStack myStack;
	
	

	public StackProducer(MyStack myStack) {
		super();
		this.myStack = myStack;
	}


	@Override
	public void run() {
      try {
		for(int i=0; i<7;i++) {
			myStack.push((char)((char)i+1));
		}
      }catch(InterruptedException e) {
    	  e.printStackTrace();
      }
		
	}
	
	
}
