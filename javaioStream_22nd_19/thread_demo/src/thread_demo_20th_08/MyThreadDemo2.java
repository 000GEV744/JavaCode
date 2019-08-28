package thread_demo_20th_08;

public class MyThreadDemo2 implements Runnable{

	@Override
	public void run() {
		
		for(int j=0;j<20;j++) {
			System.out.println("j==> "+j);
			if(j==10) {
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
