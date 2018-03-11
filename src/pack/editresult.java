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
 * Servlet implementation class editresult
 */
@WebServlet("/editresult")
public class editresult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editresult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession s=request.getSession();
		String examname=request.getParameter("x");
		String netid=s.getAttribute("id").toString();
		String name=request.getParameter("name");
		System.out.println("examname:"+examname);
		System.out.println("name:"+name);
		ArrayList<showresult> result = new ArrayList<showresult>();
		Alist a=new Alist();
		result = a.Getresultedit(examname, name);
		System.out.println("EXAM IN EditRESULT:"+result);
		request.setAttribute("result", result);
		RequestDispatcher rd=request.getRequestDispatcher("editresult.jsp");
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
