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
 * Servlet implementation class postexamresult
 */
@WebServlet("/postexamresult")
public class postexamresult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postexamresult() {
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
		String netid=s.getAttribute("id").toString();
		String student=request.getParameter("student");
		System.out.println("Studnt:"+student);
		String result=request.getParameter("result");
		System.out.println("Result:"+result);
		String name=request.getParameter("name");
		System.out.println("Name:"+name);
		String id=request.getParameter("id");
		dbconnection db=new dbconnection();
		ResultSet rs=db.selectdata("select * from examresult where examname='"+ name +"'  and studentname='"+ id +"'");
		try {
			if(rs.next())
			{
				request.setAttribute("zc", "Result already Posted");
				RequestDispatcher rd=request.getRequestDispatcher("showstudentexam?x="+name);
				rd.forward(request, response);
			}else
			{
//				/db.modify("insert into examresult(studentname,result,examname,netid) values ('"+ id +"','"+ result +"','"+ name +"','"+ netid +"')");
				db.postexamresult(id,result,name,netid);
				request.setAttribute("zc", "Result Posted");
				RequestDispatcher rd=request.getRequestDispatcher("showstudentexam?x="+name);
				rd.forward(request, response);
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
