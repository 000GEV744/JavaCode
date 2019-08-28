package comm.example.services;
import java.util.List;

import comm.example.model.*;


public interface EmployeeService {

	public List<Employee> getAllEmployees();
	public void createEmployee(Employee e);
	public Employee getEmployeeById(Integer id);
	public void deleteEmployeeById(Integer id);
	
}
