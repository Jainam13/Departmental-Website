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
 * Servlet implementation class addpost
 */
@WebServlet("/addpost")
public class addpost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addpost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession s=request.getSession();
		String netid= s.getAttribute("id").toString();
		String cname=request.getParameter("id");
		String post=request.getParameter("post");
		String fth=request.getParameter("fth");
		String tth=request.getParameter("tth");
		String cs=request.getParameter("cs");
		dbconnection obj=new dbconnection();
		//obj.modify("insert into facultypost(facultyid,post,course_name) values ('"+ netid +"','"+ post +"','"+ cname +"')");
		obj.addpost(netid,post,cname,fth,tth,cs);
		request.setAttribute("zc", "Posted");
		RequestDispatcher rd=request.getRequestDispatcher("selectedcourse");
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
