package comm.ibm.fsd.cd_example_3rd_sep_19.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.ibm.fsd.cd_example_3rd_sep_19.dao.CDDaoImpl;
import comm.ibm.fsd.cd_example_3rd_sep_19.entity.CD;


public class SaveCDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String artist;
    private String title;
    private Date purchasedate;
    private Integer cost;
    private String cdType;
    HttpSession session = null;
    
    public SaveCDController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doProcess(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		
		artist = request.getParameter("artist");
		title = request.getParameter("title");
		String pDate=request.getParameter("purchasedate");
		long d=Date.parse(pDate);
		System.out.println(pDate);
		
		cost=Integer.parseInt(request.getParameter("cost"));
		cdType=request.getParameter("CDType");
		
		if(cdType.equals("International_CD")) {
			
			session.setAttribute("INTERNATIONAL_CD",new CD(artist,title,new Date(d),cost));
			RequestDispatcher view = request.getRequestDispatcher("internationalCD.jsp");
			view.forward(request, response);
			
		}
		else if(cdType.equals("Special_Edition")) {
			session.setAttribute("SPECIAL_CD",new CD(artist,title,new Date(d),cost));
			RequestDispatcher view = request.getRequestDispatcher("specialEdition.jsp");
			view.forward(request, response);
		}
		else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			CDDaoImpl save=new CDDaoImpl();
			String msg = save.createCDDetails(new CD(artist,title,new Date(d),cost));
			out.println("Message: "+msg);
		}
        
		
	}
}
