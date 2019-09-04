package com.ibm.fsd.my_first_maven_demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.ibm.fsd.my_first_maven_demo.factory.MyConnectionFactory;
import com.ibm.fsd.my_first_maven_demo.model.Employees;

public class EmployeesDaoImpl implements EmployeesDao{
	
	SessionFactory factory= MyConnectionFactory.myConnectionFactory();
	Session session=null;
	
	//inserting employees into my employees table.
	
	@Override
	public void createEmployees(Employees e) {
		session= factory.openSession();
		session.getTransaction().begin();
		session.persist(e);
		System.out.println("Inserted...!!");
		session.getTransaction().commit();
	}

	
	//retrieving the employees list from my database
	//and we don't need to open and commit the session
	@Override
	public List<Employees> getAllEmployees() {
		session= factory.openSession();
		Query query=session.createQuery("from employees");
		List<Employees> list = query.getResultList();
		return list;
	}


	@Override
	public Employees getEmployeeById(Integer id) {
		session=factory.openSession();
		Employees e = session.get(Employees.class, id);
		session.getTransaction().commit();
		if(e!=null) {
			return e;
		}
		else  return null;
		
	}


	//deleting employee details by ID

	@Override
	public String deleteEmployeeById(Integer id) {
		session=factory.openSession();
		Employees e = session.get(Employees.class, id);
		if(e!=null)
		{	session.delete(e);
			session.getTransaction().commit();	
			return "deleted..!";
		}
		else {
	         return "ID not found.";
		}
	}


	//getting employees whose first name is equal to fname
	@Override
	public List<Employees> getEmployeeByFirstName(String fname) {
		session= factory.openSession();
		Query query = session.createQuery("from Employees e where e.firstName:fname");
		query.setParameter("fname", fname);
		List<Employees> employeesList = query.getResultList();
		if(!employeesList.isEmpty()) {
			return employeesList;
		}
		return null;
	}

	
	//updating employee by ID
	
	
	
	
	
	
	
}
