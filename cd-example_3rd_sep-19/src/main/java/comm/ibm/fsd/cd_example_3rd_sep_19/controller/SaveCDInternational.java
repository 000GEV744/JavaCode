package comm.ibm.fsd.cd_example_3rd_sep_19.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.ibm.fsd.cd_example_3rd_sep_19.entity.CD;


public class SaveCDInternational extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SaveCDInternational() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CD tempCD=(CD) session.getAttribute("INTERNATIONAL_CD");
		
	}

}
