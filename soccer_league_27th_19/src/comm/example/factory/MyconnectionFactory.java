package comm.example.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MyconnectionFactory {

	private static  DataSource dataSource= null;
	private static Connection connection = null;
	
	public static Connection getMySQLConnectionForMyDB() throws NamingException, SQLException {
		Context initContext = new InitialContext();
		Object o = initContext.lookup("java:comp/env/jdbc/mysql");
		dataSource = (DataSource)o;
		connection = dataSource.getConnection();
		return connection;
		
	}
}
