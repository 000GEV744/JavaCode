package message.example;

public class OuterClass {

	private int x;
	private int y;
	
	public OuterClass() {
		super();
	}
	
	public OuterClass(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
   public void outerMethod() {
	   System.out.println("CALLING outer method x: "+x+" y: "+y);
   }
	
   public class InnerClass{
	   
	   public void innerMethod() {
		   x=10;  //inner class can directly access the members of outer class but outer class can't access
		   y=20;
		   outerMethod();		
		  System.out.println("CALLING innner method x: "+x+" y: "+y);
		   
	   }
	   
	   public class Inner2{
		   
		   public void innerMethod2() {
			   x=40;
			   outerMethod();			   
		   }
	   }
   }
}
