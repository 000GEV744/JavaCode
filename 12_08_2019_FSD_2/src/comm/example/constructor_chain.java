package comm.example;

public class constructor_chain {

	private int x;
	private int y;
	private int z;
	
	public constructor_chain() {
		this(10); //this will find the constructor which has one argument in it   
	}
	public constructor_chain( int x) {
		this(x,20);//this will find the constructor which has two argument in it
	}
	public constructor_chain(int x, int y) {
		this(x,y,30); //this will find the constructor which has three argument in it
	}
	public constructor_chain(int x, int y, int z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public String getXYZ() {
		return ("X-"+x+", Y- "+y+", Z- "+z);
	}
	
}
