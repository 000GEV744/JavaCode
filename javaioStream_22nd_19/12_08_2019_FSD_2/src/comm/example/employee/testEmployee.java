package comm.example.employee;


public class testEmployee {
	public static void main(String args[]) {
	Employee e =null;
	e=new ContractualEmployee(01,"Anuj"," Singh","FSD",4,56);
	System.out.println(e.getDetails());
	e=new PermanentEmployee(01,"Ambikesh","Gupta","FSD",6000);
	System.out.println(e.getDetails());
	}
}
