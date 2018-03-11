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
 * Servlet implementation class alumnipost
 */
@WebServlet("/alumnipost")
public class alumnipost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alumnipost() {
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
		String netid= s.getAttribute("id").toString();
		String name=request.getParameter("name");
		String member=request.getParameter("member");
		String link=request.getParameter("link");
		String founded=request.getParameter("founded");
		dbconnection obj=new dbconnection();
		ResultSet rs=obj.selectdata("select * from alumni where name='"+ name +"'and members='"+ member +"'and founded='"+ founded +"'and link='"+ link +"'");
		try {
			if(rs.next())
			{
				request.setAttribute("zc", "Alumni Already addded");
				RequestDispatcher rd=request.getRequestDispatcher("postalumni.jsp?x="+netid);
				rd.forward(request, response);
			}else{
				obj.alumnipost(name,member,founded,link);
				request.setAttribute("zc", "Alumni Details addded");
				RequestDispatcher rd=request.getRequestDispatcher("postalumni.jsp?x="+netid);
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//obj.modify("insert into alumni(name,members,founded,link) value('"+ name +"','"+ member +"','"+ founded +"','"+ link +"')");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
