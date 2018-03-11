package pack;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class createtopic
 */
@WebServlet("/createtopic")
public class createtopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createtopic() {
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
		String netid=(String) s.getAttribute("id");
		System.out.println("Netid:"+netid);
		String topicname=request.getParameter("topic");
		System.out.println("topic:"+topicname);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		dbconnection obj=new dbconnection();
		ResultSet rs=obj.selectdata("select name from topic where name='"+ topicname +"'");
		try {
			if(rs.next())
			{
				request.setAttribute("zc", "Topic Already Added");
		   	  	RequestDispatcher dispatch=request.getRequestDispatcher("createdistopic.jsp");
		    	dispatch.include(request,response);
			}
			else{
				System.out.println("topic in");
				//obj.modify("insert into topic(name,date,netid) values ('"+ topicname+"','"+ dateFormat.format(date) +"','"+ netid +"')");
				obj.addtopic(topicname,dateFormat.format(date),netid);
				request.setAttribute("zc", "Topic Added");
		   	  	RequestDispatcher dispatch=request.getRequestDispatcher("createdistopic.jsp");
		    	dispatch.include(request,response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
