package jdbc_connector_9th_19;
import java.sql.*;
import java.util.Scanner;
import java.util.Properties;
public class JdbcDemo {

//	private static Properties properties = null;
//	static {
//		properties = new Properties();
//		properties.put("JDBC", "jdbc:mysql://localhost:3306/mydb");
//		properties.put("USER","root");
//		properties.put("PASS","27-Feb-2019");
//	}
	private static Scanner scanner=new Scanner(System.in);
//
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
//		// TODO Auto-generated method stub
//        Connection connection = DriverManager.getConnection(properties.getProperty("JDBC"),properties.getProperty("USER"),properties.getProperty("PASS"));
//        Statement statement = connection.createStatement();
//        ResultSet rs= statement.executeQuery("select * from employee");
//        System.out.println(connection);
//        System.out.println("ID NAME SALARY");
//        while(rs.next()) {
//        	System.out.printf("%d %s %d\n",rs.getInt(1),rs.getString(2),rs.getInt(3));
//        }
//	}
        MySqlConnectionFactory factory=MySqlConnectionFactory.createConnection();		
		Connection connection=factory.getConnection();
		
		//inserting into table values
//		PreparedStatement pst=connection.prepareStatement("insert into employee values(?,?,?)");
//		System.out.print("ID: ");
//		int id=scanner.nextInt();
//		System.out.print("NAME: ");
//		String name=scanner.next();
//		System.out.print("AMOUNT: ");
//		int amount=scanner.nextInt();
//		pst.setInt(1, id);
//		pst.setString(2, name);
//		pst.setInt(3, amount);
//		int count=pst.executeUpdate();
//		System.out.println(count+" row(s) updated");
//		
		
		
		//updating the table values
		System.out.println("*******update employee name******\n");
		PreparedStatement pst=connection.prepareStatement("update employee set empname= ? where empid = ?");
		System.out.print("ID: ");
		int id=scanner.nextInt();
		System.out.print("update NAME: ");
		String name=scanner.next();
		pst.setString(1, name);
		pst.setInt(2, id);
		int count=pst.executeUpdate();
		System.out.println(count+" row(s) updated");
		
		
		
	}
	
	
	
}
