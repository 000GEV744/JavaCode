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

/**
 * Servlet implementation class AddLeagueViewServlet
 */
@WebServlet(
		urlPatterns = { "/add_league.php" }, 
		initParams = { 
				@WebInitParam(name = "season-list", value = "Summer,Winter,Autumn,Spring")
		})
public class AddLeagueViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String sList;
    
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		sList=config.getInitParameter("season-list");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        out.println("<html><body>");
		
		@SuppressWarnings("unchecked")
		List<String> err=(List<String>) request.getAttribute("ERROR");
		if(err!=null)
		{
			for(String s:err)
			{
				out.println("<font color='red'>"+s+"</font><br/>");
			}
		}
		
		out.println("<form action='add_league.do' method='post'>");
		out.println("Title<input type='text' name='title'><br/>");
		out.println("Year<input type='text' name='year'><br/>");
		//String sList=getServletConfig().getInitParameter("season-list");
		String arrSList[]=sList.split(",");
		out.println("<select name='season'><option value='Unknown'>Unknown</option>");
		for(String str:arrSList)
		{
			out.println("<option value='"+str+"'"+">"+str+"</option>");
		}
		
		out.println("</select><br/><input type='submit' value='add league'></form></body></html>");
		
	}

}
