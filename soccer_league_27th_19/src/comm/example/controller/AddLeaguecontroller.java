package comm.example.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.factory.MyconnectionFactory;
import comm.example.model.League;

/**
 * Servlet implementation class AddLeaguecontroller
 */
public class AddLeaguecontroller extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
	private String season,title,year;
	private int iYear;
	private List<String> errMsgs;
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException, SQLException {
		
		errMsgs=new LinkedList<String>();
		season=  request.getParameter("season");
		if(season.equals("Unknown")) {
			errMsgs.add("Please add a valid season. ");
		}
		year= request.getParameter("year");
		try {
			iYear=Integer.parseInt(year);
		} catch (Exception e) {
		    errMsgs.add("Please add a valid year");
		}
		title=request.getParameter("title");
		if(title.length()<5) {
			errMsgs.add("title is too short. ");
		}
		
		if(errMsgs.isEmpty()) {
			request.setAttribute("SUCCESS", new League(title, season, iYear));
			Connection connection = MyconnectionFactory.getMySQLConnectionForMyDB();
			PreparedStatement pd = connection.prepareStatement("insert into league(title,season,year,uid) values(?,?,?,?)");
			pd.setString(1, title);
			pd.setString(2,season);
			pd.setInt(3,iYear);
			pd.setInt(4, League.serialVersionUID++);
			pd.executeUpdate();
			
			RequestDispatcher view=null;view = request.getRequestDispatcher("success.view");
			view.forward(request, response);
		}
		else {
			request.setAttribute("ERROR", errMsgs);
			RequestDispatcher view=null;
			view = request.getRequestDispatcher("add_league.php");
			view.forward(request, response);
		}
				
		
	}

}
