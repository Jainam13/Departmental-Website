package pack;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class postann
 */
@WebServlet("/postann")
public class postann extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postann() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String ann=request.getParameter("post");
		String id=request.getParameter("id");
		System.out.println("ANN:"+ann);
		System.out.println("id:"+id);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		dbconnection db=new dbconnection();
		ResultSet rs=db.selectdata("select firstname from fsregistration where netid='"+ id +"'");
		try {
			while(rs.next())
			{
				String name=rs.getString(1);
				db.postann(ann,name,dateFormat.format(date));
				request.setAttribute("zc", "Announcement Posted");
				RequestDispatcher rd=request.getRequestDispatcher("postann.jsp?x="+id);
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//db.modify("insert into announ(announcement,netid,date) values('"+ ann +"','"+ id +"','"+dateFormat.format(date)+"')");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
