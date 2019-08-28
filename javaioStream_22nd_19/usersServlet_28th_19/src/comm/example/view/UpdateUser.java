package comm.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.factory.MyconnectionFactory;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/update_user.view")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String name,password,email,country;
    private int id;
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
		 List<String> errMsgs=new LinkedList<String>();
		 id=Integer.parseInt(request.getParameter("id"));
		name=request.getParameter("name");
		password=request.getParameter("password");
		email=request.getParameter("email");
		country=request.getParameter("country");
		
		if(country.equals("Unknown")) {
			errMsgs.add("enter valid country");
		}
		if(password.length()<4) {
	    	errMsgs.add("your password is too short");
	    }
		
		 if(errMsgs.isEmpty()) {
		Connection connection = MyconnectionFactory.getMySQLConnectionForMyDB();
		PreparedStatement ps = connection.prepareStatement("update users set name=?,password=?,email=?,country=? where id=?");
		ps.setString(1, name);
		ps.setString(2, password);
		ps.setString(3, email);
		ps.setString(4, country);
		ps.setInt(5, id);
		ps.executeUpdate();
		out.println("<b>User Updated</b>");
		out.println("<a href='all_users.view'>Back</a>");
		 }
		 else {
		    	request.setAttribute("ERROR", errMsgs);
		    	view = request.getRequestDispatcher("edit_users.view");
	            view.forward(request, response);
		    }
		}

}
