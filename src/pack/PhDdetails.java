package pack;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PhDdetails
 */
@WebServlet("/PhDdetails")
public class PhDdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhDdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession s = request.getSession();
		ArrayList<studentregistration> co = new ArrayList<studentregistration>();
		Alist obj=new Alist();
		co = obj.GetPhDstudents();
		request.setAttribute("PhD", co);
		System.out.println("Co:"+co);
		if(co.isEmpty()==true)
		{
			request.setAttribute("zc", "No PhD students");
			RequestDispatcher rd=request.getRequestDispatcher("showPhDstudents.jsp");
			rd.forward(request, response);
		}
		RequestDispatcher rd=request.getRequestDispatcher("showPhDstudents.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
