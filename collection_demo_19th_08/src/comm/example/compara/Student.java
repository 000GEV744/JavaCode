package comm.example.compara;

public class Student implements Comparable<Object>{

	
	private String fName;
	private String lName;
	private double gpa;
	
	
	
	public Student() {
		super();
	}


	public Student(String fName, String lName, double gpa) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.gpa = gpa;
	}
	
	
	@Override
	public String toString() {
		return "Student [fName=" + fName + ", lName=" + lName + ", gpa=" + gpa + "]";
	}
	
	public String getfName() {
		return fName;
	}
	
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getlName() {
		return lName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	

	public double getGpa() {
		return gpa;
	}


	public void setGpa(double gpa) {
		this.gpa = gpa;
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Student student = (Student)o;
		if(this.getGpa()==student.getGpa()) {
			return 0;
		}
		else if(this.getGpa()>student.getGpa()) {
			return 1;
		}
		else {
		return -1;
		}
	}
	
}
