package comm.example.employee;

public class PermanentEmployee extends Employee  {
private int salary;

public PermanentEmployee(int id,String fname,String lname, String dept, int salary) {
	super(id,fname,lname,dept);
	this.salary = salary;
}

@Override
protected String getDetails() {
	// TODO Auto-generated method stub
	return super.getDetails()+" and the salary of the employee is: "+salary;
}
}