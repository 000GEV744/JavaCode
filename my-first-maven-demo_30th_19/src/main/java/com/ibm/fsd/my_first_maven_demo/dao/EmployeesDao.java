package com.ibm.fsd.my_first_maven_demo.dao;

import java.util.List;

import com.ibm.fsd.my_first_maven_demo.model.Employees;



public interface EmployeesDao {
	
	public void createEmployees(Employees e);
	public List<Employees> getAllEmployees();
	public Employees getEmployeeById(Integer id);
	public String deleteEmployeeById(Integer id);
	public  List<Employees> getEmployeeByFirstName(String fname);
	
}
