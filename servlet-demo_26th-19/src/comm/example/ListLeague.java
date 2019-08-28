package comm.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import comm.example.model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListLeague
 */
@WebServlet("/list_leagues.view")
public class ListLeague extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   //no need of constructor here as our web container is responsible for loading the view page

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		List<League> list=new ArrayList<League>();
		list.add(new League("Soccer League","Summer",2009));
		list.add(new League("Swiming League","Summer",2019));
		list.add(new League("Basket Ball League","Autumn",2009));
		list.add(new League("Beach Volley","Winter",2015));
		out.println("<table><tr><td>Title</td><td>Year</td><td>Season</td></tr>");
		for(League l:list)
		{
			out.println("<tr><td>"+l.getTitle()+"</td><td>"+l.getLeagueYear()+
					"</td><td>"+l.getSeason()+"</td></tr>");
		}
		out.println("</table>");
		
		
	}
	

}
