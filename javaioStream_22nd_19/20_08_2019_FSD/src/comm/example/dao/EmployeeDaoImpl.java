package comm.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import comm.example.factory.*;
import comm.example.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private Connection conn=null;
	private PreparedStatement pst=null;
	private MyConnectionFactory factory=null;
	private Statement st=null;
	private ResultSet rs=null;
	
	
	public EmployeeDaoImpl() throws SQLException {
		super();
		factory =MyConnectionFactory.createObject();
		conn=MyConnectionFactory.getConnection();
	}

	//getting all the employee form my database mydb which is having employee table
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list= new ArrayList<Employee>();
		try {
               st=conn.createStatement();
               rs=st.executeQuery("select * from employee");
               while(rs.next()) {
            	   list.add(new Employee(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
               }
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

	//inserting the employee values into the table employee
	@Override
	public void createEmployee(Employee e){
	try {	
		pst=conn.prepareStatement("insert into employee values(?, ?, ?, ?,?)");
		pst.setInt(1,e.getId());
		pst.setString(2, e.getfName());
		pst.setString(3, e.getlName());
		pst.setString(4, e.getEmail());
		pst.setInt(5, e.getDeptId());
		pst.executeUpdate();
	}catch(SQLException ex) {
		System.out.println("Duplicate id or duplicate email\n");
		ex.printStackTrace();
	}
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Employee emp=null;
		
		try {
			pst=conn.prepareStatement("select * from employee where id=?");
			pst.setInt(1, id);
			rs= pst.executeQuery();
			while(rs.next()) {
			emp=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		try {
			pst=conn.prepareStatement("delete from employee where id=?");
			pst.setInt(1, id);
			pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
