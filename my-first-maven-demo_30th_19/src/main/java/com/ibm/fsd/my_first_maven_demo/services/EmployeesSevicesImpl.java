package com.ibm.fsd.my_first_maven_demo.services;

import java.util.List;
import com.ibm.fsd.my_first_maven_demo.dao.EmployeesDaoImpl;
import com.ibm.fsd.my_first_maven_demo.model.Employees;

public class EmployeesSevicesImpl implements EmployeesServices {

	EmployeesDaoImpl dao=null;
	
	@Override
	public void createEmployees(Employees e) {
		dao.createEmployees(e);
	}

	@Override
	public List<Employees> getAllEmployees() {
		List<Employees>EmployeesList = dao.getAllEmployees();
		return EmployeesList ;
	}

	@Override
	public Employees getEmployeeById(Integer id) {
		Employees e = dao.getEmployeeById(id);
		return e;
	}

	@Override
	public String deleteEmployeeById(Integer id) {
		String deleteMsg=dao.deleteEmployeeById(id);
		return deleteMsg;
	}

	@Override
	public List<Employees> getEmployeeByFirstName(String fname) {
		List<Employees> fNameEmployee = dao.getEmployeeByFirstName(fname);
		return fNameEmployee;
	}

}
