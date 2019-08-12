package comm.example.employee;

public class ContractualEmployee extends Employee {
	private int rate;
	private int hour;
    private int salary;
	public ContractualEmployee(int id,String fname,String lname, String dept, int rate, int hour) {
		super(id,fname,lname,dept);
		this.rate = rate;
		this.hour = hour;
	}

	@Override
	protected String getDetails() {
		salary=rate*hour;
		// TODO Auto-generated method stub
		return super.getDetails()+" and the salary of the employee is: "+salary;
	}

}
