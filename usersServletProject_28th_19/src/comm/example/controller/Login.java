package comm.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    RequestDispatcher view=null;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String email=request.getParameter("email");
	     String pass=request.getParameter("password");
	     System.out.println(email);
	     System.out.println(pass);
	     
	     List<String> credentials= new ArrayList<String>();
	     credentials.add(email);
	     credentials.add(pass);
	     
	     javax.servlet.ServletContext ctx = request.getServletContext();
	     ctx.setAttribute("CREDENTIALS", credentials);
	     request.setAttribute("SUCCESS","password" );
		 view = request.getRequestDispatcher("login.jsp");
		 view.forward(request, response);
    }
}

