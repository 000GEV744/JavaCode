package comm.example.services;
import java.sql.SQLException;
import java.util.List;

import comm.example.dao.*;
import comm.example.model.Employee;
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDaoImpl dao=null;

	
	public EmployeeServiceImpl() throws SQLException {
		super();
		dao=new EmployeeDaoImpl();	
	}

	@Override
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployee();
		
	}

	@Override
	public void createEmployee(Employee e) {
		dao.createEmployee(e);
		
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return dao.getEmployeeById(id);
		
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteEmployeeById(id);
	}
	
}
