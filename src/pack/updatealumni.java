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
 * Servlet implementation class updatealumni
 */
@WebServlet("/updatealumni")
public class updatealumni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatealumni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession s = request.getSession();
		int id=Integer.parseInt(request.getParameter("alumniid"));
		System.out.println("id:"+id);
		String name = request.getParameter("name");
		System.out.println("name:"+name);
		String member = request.getParameter("member");
		System.out.println("member:"+member);
		String founded = request.getParameter("founded");
		System.out.println("founded:"+founded);
		String link = request.getParameter("link");
		System.out.println("link:"+link);
		dbconnection obj=new dbconnection();
		obj.modify("update alumni set name='"+ name +"',members='"+ member +"',founded='"+ founded +"',link='"+ link +"' where alumni_id='"+ id +"'");
		RequestDispatcher rd=request.getRequestDispatcher("alumnidetails");
		rd.forward(request, response);
	}

}
