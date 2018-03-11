package pack;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class postjobs
 */
@WebServlet("/postjobs")
public class postjobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postjobs() {
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
		String name=s.getAttribute("name").toString();
		String job=request.getParameter("job");
		String link=request.getParameter("link");
		String location=request.getParameter("location");
		dbconnection obj=new dbconnection();
		System.out.println("id:"+name);
		System.out.println("link:"+link);
		System.out.println("job:"+job);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		//obj.modify("insert into jobs(netid,linkjob,jobs,date,location) values('"+ id +"','"+ link +"','"+ job +"','"+dateFormat.format(date)+"','"+ location +"')");
		obj.postjobs(name,link,job,dateFormat.format(date),location);
		request.setAttribute("zc", "Job Post added");
		RequestDispatcher rd=request.getRequestDispatcher("postjob.jsp?x="+name);
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
