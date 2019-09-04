package comm.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = { "/save_servlet.view" }, 
		initParams = { 
				@WebInitParam(name = "country", value = "INDIA, USA, UK, CHINA, JAPAN")
		})
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String country;
   
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		country=config.getInitParameter("country");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request,response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String[] countryList=country.split(", ");
		
		
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" );
		
		@SuppressWarnings("unchecked")
		List<String> err=(List<String>) request.getAttribute("ERROR");
		String success=(String) request.getAttribute("SUCCESS");
		//checking if there is any error from server side validation
		if(err!=null) {
			out.println("<b>Fix the following ERRORS !</br></b>");
			for(String s: err) {
				out.println("<font color='red'>"+s+"</font><br/>");
			}
		}
		
		//in case there is no error and data got saved successfully then print the message on the same view page
		else if(success!=null) {
			out.println(success);
		}
		
		//and then continue with the normal flow of showing the form in the view page 
		out.println("<h1>ADD USERs....</h1><br/>\r\n" + 
				"	<form action=\"save_Users.dao\" method=\"post\">\r\n" + 
				"	<table>\r\n" + 
				"	<tr>\r\n" + 
				"		<td><label>Name:</label></td>\r\n" + 
				"		<td><input id=\"input-1\" required=\"true\" name=\"name\" type=\"text\"/></td>\r\n" + 
				"    </tr>		\r\n" + 
				"	<tr>\r\n" + 
				"		<td><label for=\"input-2\">Password:</label></td>\r\n" + 
				"		<td><input id=\"input-2\" name=\"password\" required=\"true\" type=\"password\"/></td>\r\n" + 
				"	</tr>\r\n" + 
				"	<tr>\r\n" + 
				"		<td><label for=\"input-3\">Email:</label></td>\r\n" + 
				"		<td><input id=\"input-3\" name='email' required=\"true\" type=\"email\"/></td>\r\n" + 
				"	</tr>\r\n" + 
				"	<tr>\r\n" + 
				"	    <td><label>Country</label></td>\r\n" + 
				"		<td><select name=\"country\">\r\n" );
		out.println("<option value='Unknown'>Select...</option>\r\n");
		for(String s:countryList) {
		     out.println("<option value='"+s+"'>"+s+"</option>\r\n");
		} 
				out.println("</select></td>\r\n" + 
				"		    \r\n" + 
				"    </tr>\r\n" + 
				"    \r\n" + 
				"    	<tr><td></td></tr>\r\n" + 
				"		<tr><td><input type=\"submit\" value=\"Save Employee\" id=\"button-1\"/></td></tr>\r\n" + 
				"		</table>\r\n" + 
				"	</form>\r\n" + 
				"\r\n" +
				"<br><br><li><a href='all_users.view'>List USERS</a></li>"+
				"</body>\r\n" + 
				"</html>");
		
	}
}
