package jdbc_connector_9th_19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionFactory {

	private static Connection connection = null;
	private static MySqlConnectionFactory connectionFactory;
	
	//connection details and getting connection object
	private MySqlConnectionFactory() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","27-Feb-2019");
	}
	
	//creating object of the class MySqlConnectionFactory  and returning its instance
	public static MySqlConnectionFactory createConnection() throws SQLException{
		if(connectionFactory==null) {
			connectionFactory=new MySqlConnectionFactory(); 
		}
		return connectionFactory;
	}
	
	//returning the connection that we got in the constructor
	public Connection getConnection() throws SQLException{
		return connection;
	}
}
