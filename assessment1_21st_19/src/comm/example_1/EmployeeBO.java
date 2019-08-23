package comm.example_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeBO {

	 static List<Employee> ls= new ArrayList<Employee>();	 
	 public static void printEmployees(List ls) {
		 EmployeeBO.ls=ls;
		 for(Employee e:EmployeeBO.ls) {
			 System.out.printf("EmpId: %d\tEmpName: %s\tEmpDepartment: %s\t EmpDateOfJoining: %s\tEmpSalary: %d\t EmpAge: %d\n",e.getId(),e.getName(),e.getDepartment(),e.getDateOfJoining(),e.getSalary(),e.getAge());
		 }
	 }
	
}
