package comm.example_1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;  

public class Employee implements Comparable{

	private static int count=0; 
	private int id;
	private String name;
	private String department;
	private Date dateOfJoining;
	private int age;
	private int salary;
	
	
	public Employee( String name, String department, Date dateOfJoining, int age, int salary) {
		
		this.id=++count;
		this.name = name;
		this.department = department;
		this.dateOfJoining = dateOfJoining;
		this.age = age;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	
	public void setDataOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public int compareTo(Object o) {
		Employee e=(Employee)o;
		if(this.getSalary()>e.getSalary()) {
			return 1;
		}
		else if(this.getSalary()<e.getSalary()) {
			return -1;
		}
		else return 0;
	}

	@Override
	public String toString() {
		
		SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
		String str=formatter1.format(dateOfJoining);
		String output=String.format("\"%-15s %-30s %-30s %-10s %-10s\\n\",String.valueOf(id),str,name,department,String.valueOf(salary)");
		return output;
	
	}
	
	
}
