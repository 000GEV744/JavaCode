package comm.example.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnectionFactory {

	private static Connection conn;
	private static MyConnectionFactory factory=null;
	
	private MyConnectionFactory() throws SQLException{ 
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","27-Feb-2019");
		
	}
	
	
	public static MyConnectionFactory createObject() throws SQLException{
		if(factory==null) {
			factory = new MyConnectionFactory();
		}
		return factory;
	}
	
	public static Connection getConnection() throws SQLException{
		return conn;
	}
}
