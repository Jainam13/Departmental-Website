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
 * Servlet implementation class addreserveresource
 */
@WebServlet("/addreserveresource")
public class addreserveresource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addreserveresource() {
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
//		System.out.println(s.getAttribute("Firstname"));
		String name=request.getParameter("name");
		System.out.println(name);
		String time=request.getParameter("time");
		System.out.println(time);
		String date=request.getParameter("date");
		dbconnection obj=new dbconnection();
		System.out.println("Date:"+date);
		ResultSet rs2=obj.selectdata("select nameofresource from resource where resource_id='"+ name +"'");
		try {
			while(rs2.next())
			{
				String resourcename1=rs2.getString("nameofresource");
				ResultSet rs=obj.selectdata("select  * from reservedresource where resourcename='"+ resourcename1 +"' and date='"+ date +"' and time='"+ time +"'");
			
				if(rs.next())
				{
					request.setAttribute("zc", "Resource already Reserved");
					RequestDispatcher rd=request.getRequestDispatcher("resourcedetails?x="+netid);
					rd.forward(request, response);
				}else{
					
					
						//obj.modify("insert into reservedresource(resourcename,date,time,netid) value('"+ resourcename1 +"','"+ date +"','"+ time +"','"+ netid +"')");
						obj.reserveresource(resourcename1,date,time,netid);
						request.setAttribute("zc", "Resource Reserved");
						RequestDispatcher rd=request.getRequestDispatcher("resourcedetails?x="+netid);
						rd.forward(request, response);
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
