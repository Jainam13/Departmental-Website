package pack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class updateexamresult
 */
@WebServlet("/updateexamresult")
public class updateexamresult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateexamresult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String examname=request.getParameter("name");
		String sname=request.getParameter("sname");
		String result=request.getParameter("result");
		
		HttpSession s=request.getSession();
		String netid=s.getAttribute("id").toString();
		dbconnection obj=new dbconnection();
		obj.modify("update examresult set result='"+ result +"' where examname='"+ examname +"' and studentname='"+ sname +"'");
		request.setAttribute("zc", "Result Updated");
		
  	  RequestDispatcher dispatch=request.getRequestDispatcher("/editresult?x="+examname+"&name="+sname);
   	  dispatch.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
