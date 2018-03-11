package pack;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addexam
 */
@WebServlet("/addexam")
public class addexam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addexam() {
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
		String name=request.getParameter("name");
		String date=request.getParameter("date");
		String link=request.getParameter("link");
		dbconnection obj=new dbconnection();
		ResultSet rs=obj.selectdata("select * from exam where exam_name='"+ name +"' and date='"+ date +"' and facultyid='"+  netid+"'");
		try {
			if(rs.next())
			{
				request.setAttribute("zc", "Exam already added");;
		    	  RequestDispatcher dispatch=request.getRequestDispatcher("addexam.jsp");
		     	  dispatch.forward(request,response);
			}else{
				if(link=="")
				{
					//obj.modify("insert into exam(exam_name,date,link,facultyid) values ('"+ name +"','"+ date +"','Link Not Provided','"+ netid +"')");
					obj.addexam(name, date,"Link Not Provided",netid);
					request.setAttribute("zc", "Exam added");;
			    	  RequestDispatcher dispatch=request.getRequestDispatcher("addexam.jsp");
			     	  dispatch.forward(request,response);
				}else
				{
					//obj.modify("insert into exam(exam_name,date,link,facultyid) values ('"+ name +"','"+ date +"','"+ link +"','"+ netid +"')");
					obj.addexam(name, date,link,netid);
					request.setAttribute("zc", "Exam added");;
			    	  RequestDispatcher dispatch=request.getRequestDispatcher("addexam.jsp");
			     	  dispatch.forward(request,response);
				}
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
