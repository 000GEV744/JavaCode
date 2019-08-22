package comm.example.dao;
import comm.example.model.*;
import java.util.List;

public interface EmployeeDao {

	public List<Employee> getAllEmployee();
	public void createEmployee(Employee e);
	public Employee getEmployeeById(Integer id);
	public void deleteEmployeeById(Integer id);
	
}
