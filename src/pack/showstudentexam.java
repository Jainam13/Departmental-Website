package pack;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class showstudentexam
 */
@WebServlet("/showstudentexam")
public class showstudentexam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showstudentexam() {
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
		String netid=s.getAttribute("id").toString();
		System.out.println("NETID IN SHOWSTU:"+netid);
		String examname=request.getParameter("x");
		System.out.println("examname:"+examname);
		dbconnection db=new dbconnection();
		ResultSet rs=db.selectdata("select netid from studentexamsignup where nameofexam='"+ examname +"' and id='"+ netid +"'");
		try {
			if(rs.next())
			{
				String firstname=rs.getString("netid");
				System.out.println("firstname:"+firstname);
				ArrayList<studentexamsignup> studentexam = new ArrayList<studentexamsignup>();
				//ArrayList<exam> exam = new ArrayList<exam>();
				Alist obj=new Alist();
				studentexam = obj.Getstudentexam(examname);
				//exam=obj.Getexam(netid);
				//System.out.println("studentexam:"+resource);
				System.out.println("studentexam:"+studentexam);
				//request.setAttribute("resource", studentexam);
				request.setAttribute("exam", studentexam);
				getServletContext().getRequestDispatcher("/postexamresult.jsp?x="+examname+"&name="+firstname).forward(request, response);
			}else{
				ArrayList<studentexamsignup> studentexam = new ArrayList<studentexamsignup>();
				//ArrayList<exam> exam = new ArrayList<exam>();
				Alist obj=new Alist();
				studentexam = obj.Getstudentexam(examname);
				//exam=obj.Getexam(netid);
				//System.out.println("studentexam:"+resource);
				System.out.println("studentexam:"+studentexam);
				//request.setAttribute("resource", studentexam);
				request.setAttribute("exam", studentexam);
				getServletContext().getRequestDispatcher("/postexamresult.jsp?x="+examname).forward(request, response);
	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		RequestDispatcher rd=request.getRequestDispatcher("/reserveresource.jsp");
//		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
