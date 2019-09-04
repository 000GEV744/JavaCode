package comm.example.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import comm.example.model.*;

/**
 * Servlet Filter implementation class LoginFilter2
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/login" })
public class LoginFilter2 implements Filter {

    RequestDispatcher view=null;
    
    public LoginFilter2() {
       
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String email= request.getParameter("email");
		String password = request.getParameter("password");
		Users user= new Users();
		int flag=0;
		List<String> passowrdList= new ArrayList<String>();
		try {
			passowrdList=user.passwordValidation(email);
			for(String s : passowrdList) {
				
				if(s.equals(password)) {
					  flag=1;
                      chain.doFilter(request, response);
				}
				
			}
			if(flag==0) {
				request.setAttribute("ERROR", "username or password is incorret !!");
				view = request.getRequestDispatcher("login.jsp");
				view.forward(request, response);
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
