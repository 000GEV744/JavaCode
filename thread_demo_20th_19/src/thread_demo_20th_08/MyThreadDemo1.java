package thread_demo_20th_08;

public class MyThreadDemo1 implements Runnable {

	public static void main(String[] args) {
		MyThreadDemo1 myThread1 = new MyThreadDemo1();
		MyThreadDemo2 myThread2 = new MyThreadDemo2();
		Thread t1=new Thread(myThread1);  //mythread1  is runnable object
		Thread t2=new Thread(myThread2);
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.start();
		System.out.println(t2.isAlive());
		
		
	}
	@Override
	public void run() {
			
		for(int i=0;i<20;i++) {
			System.out.println("==>: "+i);
		}
		
	}

}
