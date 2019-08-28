package comm.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import comm.example.model.*;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.factory.MyconnectionFactory;
import comm.example.model.Users;

/**
 * Servlet implementation class SaveUsersDb
 */
@WebServlet("/save_Users.dao")
public class SaveUsersDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String name, email, password,country;
    
    RequestDispatcher view=null;
   
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
	     name=request.getParameter("name");
	     email=request.getParameter("email");
	     country=request.getParameter("country");
	     List<String> errMsgs=new LinkedList<String>();
	     if(country.equals("Unknown")) {
	    	 errMsgs.add("enter valid country");
	     }
	    password=request.getParameter("password");
	    if(password.length()<4) {
	    	errMsgs.add("your password is too short");
	    }
	    
	    if(errMsgs.isEmpty()) {
	    	Connection connection = MyconnectionFactory.getMySQLConnectionForMyDB();
	    	PreparedStatement ps=connection.prepareStatement("insert into users(name,email,password,country, uid) values(?,?,?,?,?)");
	    	ps.setString(1,name );
	    	ps.setString(2, email);
	    	ps.setString(3, password);
	    	ps.setString(4, country);
	    	ps.setInt(5, Users.serialVersionUID++);
	    	ps.executeUpdate();
	    	request.setAttribute("SUCCESS","successfully added..!");
	    	view = request.getRequestDispatcher("save_servlet.view");
	    	view.forward(request, response);
	    }
	    else {
	    	request.setAttribute("ERROR", errMsgs);
	    	view = request.getRequestDispatcher("save_servlet.view");
            view.forward(request, response);
	    }
	    
	    
	    
	}

}
