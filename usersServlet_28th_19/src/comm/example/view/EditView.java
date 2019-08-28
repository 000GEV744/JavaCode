package comm.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.factory.MyconnectionFactory;
import comm.example.model.Users;

@WebServlet(
		urlPatterns = { "/edit_users.view" }, 
		initParams = { 
				@WebInitParam(name = "country", value = "INDIA, USA, UK, CHINA, JAPAN")
		})

public class EditView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String country;
   
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		country=config.getInitParameter("country");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, NamingException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String[] countryList=country.split(", ");
		
		int id= Integer.parseInt(request.getParameter("uId"));
		System.out.println(id);
		Connection connection = MyconnectionFactory.getMySQLConnectionForMyDB();
		PreparedStatement pw = connection.prepareStatement("select * from users where id= ? ");
		pw.setInt(1, id);
		ResultSet rs = pw.executeQuery();
		
		List<Users> users=new ArrayList<Users>();
		while(rs.next()) {
			users.add(new Users(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}
		Users u= users.get(0);
		
		@SuppressWarnings("unchecked")
		List<String> err=(List<String>) request.getAttribute("ERROR");
		if(err!=null) {
			out.println("<b>Fix the following ERRORS !</br></b>");
			for(String s: err) {
				out.println("<font color='red'>"+s+"</font><br/>");
			}
		}
		
		
		out.println("\r\n" + 
				"<h1>update the User</h1>"
				+ "<form action=\"update_user.view\" name=\"editForm\" id=\"form-1\" action=\"post\">\r\n" + 
				"	<table id=\"table-1\">\r\n" + 
				"<tr>"
				+ "<td><label><b>ID:</b></label></td>"
				+ "<td><input type=\"text\" name=\"id\" value=\""+id+"\" readonly/></td></tr>"+
				"			<tr>\r\n" + 
				"				<td><label for=\"input-1\"><b>Name</b></label></td>\r\n" + 
				"				<td><input id=\"input-1\" name=\"name\" value=\""+u.getName()+"\" required=\"true\" type=\"text\"/></td>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr>\r\n" + 
				"				<td><label for=\"input-2\"><b>Email:</b></label></td>\r\n" + 
				"				<td><input id=\"input-2\" name=\"email\" value=\""+u.getEmail()+"\" required=\"true\" type=\"email\"/></td>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr>\r\n" + 
				"				<td><label for=\"input-3\"><b>Password:</b></label></td>\r\n" + 
				"				<td><input id=\"input-3\" name=\"password\" value=\""+u.getPassword()+"\" required=\"true\" type=\"text\"/></td>\r\n" + 
				"	         </tr>\r\n" + 
				"			<tr>\r\n" + 
				"				<td><label for=\"input-4\"><b>Country:</b></label></td>\r\n"
				+ "<td><select name=\"country\">\r\n");
		
		out.println("<option value='Unknown'>Select...</option>\r\n");
		for(String s:countryList) {
		     out.println("<option value='"+s+"'>"+s+"</option>\r\n");
		} 
				out.println("</select></td>\r\n" + 
				"		    \r\n" + 
				"    </tr>\r\n" + 
				"    \r\n" + 
				"    	<tr><td></td></tr>\r\n" + 
				"		<tr><td><input type=\"submit\" value=\"Update\" id=\"button-1\"/></td></tr>\r\n" + 
				"		</table>\r\n" + 
				"	</form>\r\n");
				out.println("<a href='all_users.view'>Back</a>");
		
	}

	}

