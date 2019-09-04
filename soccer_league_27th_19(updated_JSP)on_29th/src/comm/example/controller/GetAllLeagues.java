package comm.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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


@WebServlet("/get_all_leagues.view")

public class GetAllLeagues extends HttpServlet {
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
		// TODO Auto-generated method stub
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
		Statement st= connection.createStatement();
		ResultSet rs=st.executeQuery("select * from league");
		
		String output = "<table><tr><th>TITLE</th><th>SEASON</th><th>YEAR</th></tr>";
		while(rs.next()) {
			output+=("<tr><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
		}
		output=output+"<table>";
		
		out.println(output+"\n\n");
		out.println("\n<a href=\"index.jsp\"><b>Home</b></a>");
		
	}

}
