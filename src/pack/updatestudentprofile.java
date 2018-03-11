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
 * Servlet implementation class updatestudentprofile
 */
@WebServlet("/updatestudentprofile")
public class updatestudentprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatestudentprofile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String advisor=request.getParameter("advisor");
		System.out.println("Advisor:"+advisor);
		String password=request.getParameter("p1");
		System.out.println("Pwd:"+password);
		String email=request.getParameter("email");
		System.out.println("Email:"+email);
		String phone=request.getParameter("phone");
		System.out.println("Phone:"+phone);
		HttpSession s=request.getSession();
		String netid=s.getAttribute("id").toString();
		dbconnection db=new dbconnection();
		db.updatestudentprofile(password,advisor,email,phone,netid);
		request.setAttribute("zc", "Profile Updated");
		RequestDispatcher rd=request.getRequestDispatcher("studentlogin.jsp");
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
