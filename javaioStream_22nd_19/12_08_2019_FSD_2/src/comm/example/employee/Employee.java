package comm.example.employee;

public class Employee {
  
private int empid;
private String firstName;
private String lastName;
private String dept;

public Employee(int id,String fname, String lname, String dept) {
	System.out.println("inside base class constructor");
	this.empid=id;
	this.firstName=fname;
	this.lastName=lname;
	this.dept=dept;
}

protected String getDetails() {
	return "empId: "+empid+ " Name is: "+firstName+" "+lastName+" and works in dept: "+dept;
}

}
