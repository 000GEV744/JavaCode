import comm.example.services.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import comm.example.model.*;

public class EmployeeMain {
	private static Scanner sc =  new Scanner(System.in);
	public static void main(String[] args) throws SQLException {
		
		EmployeeServiceImpl service=new EmployeeServiceImpl();
		int choice=0;
		do {
			System.out.println("\n1. create an employee.");
			System.out.println("2. display all employees.");
			System.out.println("3. display employee by ID. ");
			System.out.println("0. exit.");
			System.out.println("your choice\n");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
			
					System.out.println("employee Id: ");
					int id=sc.nextInt();
					System.out.println("employee First Name: ");
					String fname=sc.next();
					System.out.println("employee Last Name: ");
					String lname=sc.next();
					System.out.println("employee email: ");
					String email=sc.next();
					System.out.println("employee deptId: ");
					int deptno=sc.nextInt();
					service.createEmployee(new Employee(id,fname,lname,email,deptno));
					break;
					
			case 2:
				   List<Employee> list = service.getAllEmployees();
				   System.out.println("ID\tFNAME\tLNAME\tEMAIL\tdeptId");
				   for(Employee e:list) {
					   System.out.printf("%d\t%s\t%s\t%s\n",e.getId(),e.getfName(),e.getlName(),e.getEmail(),e.getDeptId());
				   }
				   break;
			case 3:
				   System.out.println("employee Id: ");
				   int empId=sc.nextInt();
				   Employee e= service.getEmployeeById(empId);
				   System.out.println("ID\tFNAME\tLNAME\tEMAIL\tDeptId");
				   System.out.printf("%d\t%s\t%s\t%s\n",e.getId(),e.getfName(),e.getlName(),e.getEmail(),e.getDeptId());
				   break;	
				   
			case 0:
				System.out.println("Bye !");
				System.exit(0);	 
				break;
				
			default:break;	   
			
			}
		}while(choice!=0);
		
		
	}

}
