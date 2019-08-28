package comm.example;

public class Calculator {

	private int x;
	private int y ;
	private int result;
	
	
	public Calculator() {
		super();
	}

	public Calculator(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		
	}
	 
	public int addMethod() {
		
		result=x + y;
		return result;
	}
	
	public int subMethod() {
		result= x-y;
		return result;
		
	}
	public int isGreaterMethod() {
		if(x>y) {
		return 1;
		}
		
		return -1;
		
	}
}
