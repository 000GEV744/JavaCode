package comm.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.factory.MyconnectionFactory;

/**
 * Servlet implementation class AllUsers
 */
@WebServlet("/all_users.view")
public class AllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException, SQLException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection connection = MyconnectionFactory.getMySQLConnectionForMyDB();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select * from users");
		String output ="<html><body><table><tr><th>name</th><th>Email</th><th>country</th></tr>";
		while(rs.next()) {
			output+=("<tr><td>"+rs.getString(2)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td><a href='edit_users.view?uId="+rs.getInt(1)+"'>Edit</a></td><td><a href='delete_users.view?uId="+rs.getInt(1)+"'>Delete</a></td></tr>");
		}
		output=output+"<table><br><a href='index.html'>Home</a></body></html>";
		out.println(output);
		
	}

}
