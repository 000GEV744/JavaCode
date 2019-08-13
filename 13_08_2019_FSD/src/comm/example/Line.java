package comm.example;

public class Line extends Model{

	
	private int startPoint;
	private int endPoint;
	private int len;
	public Line() {
		
	}
	
	public Line(int startPoint, int endPoint) {
		
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.len=this.calculateLength();
		
	}
	
	

	public int getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(int startPoint) {
		this.startPoint = startPoint;
	}

	public int getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(int endPoint) {
		this.endPoint = endPoint;
	}

	public int calculateLength() {
		return getEndPoint()- getStartPoint();
	}
	@Override
	public boolean isGreater(Object obj1, Object obj2) {
		// TODO Auto-generated method stub
		Line l1=(Line)obj1;
		Line l2=(Line)obj2;
		return l1.calculateLength()>l2.calculateLength();
	}

	@Override
	public boolean isLesser(Object obj2) {
		// TODO Auto-generated method stub
		
		Line l2=(Line)obj2;
		return len<l2.calculateLength();
		
	}

	@Override
	public boolean isEqual( Object obj2) {
		// TODO Auto-generated method stub
		
		Line l2=(Line)obj2;
		return len==l2.calculateLength();
		
	}

}
