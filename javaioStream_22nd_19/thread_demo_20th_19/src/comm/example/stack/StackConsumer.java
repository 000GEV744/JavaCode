package comm.example.stack;

public class StackConsumer implements Runnable{

	private MyStack myStack;
	
	public StackConsumer(MyStack myStack) {
		super();
		this.myStack = myStack;
	}


	@Override
	public void run() {
		for(int i=0;i<7;i++) {
			try {
				System.out.println("consumes :"+ myStack.pop());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
