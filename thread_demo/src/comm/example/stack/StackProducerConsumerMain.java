package comm.example.stack;

public class StackProducerConsumerMain {

	private static MyStack myStack=new MyStack();
	public static void main(String[] args) {
	
		Thread prodStack=new Thread(new StackProducer(myStack));
		Thread conStack=new Thread(new StackConsumer(myStack));
		prodStack.start();
		conStack.start();
	}

}
