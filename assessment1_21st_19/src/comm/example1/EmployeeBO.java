package comm.example1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeBO {

	 static Set<Employee> ls= new TreeSet<Employee>();	 
	 public static void printEmployees(Set ls) {
		 EmployeeBO.ls=ls;
		 for(Employee e:EmployeeBO.ls) {
			 System.out.printf("EmpId %d\tEmpName %s\tEmpDepartment %s\t EmpDateOfJoining %s\tEmpSalary %d\t EmpAge %d\n",e.getId(),e.getName(),e.getDepartment(),e.getDateOfJoining(),e.getSalary(),e.getAge());
		 }
	 }
	
}
