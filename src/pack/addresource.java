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
 * Servlet implementation class addresource
 */
@WebServlet("/addresource")
public class addresource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addresource() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession s=request.getSession();
		String netid= s.getAttribute("id").toString();
		String name=request.getParameter("nameofresource");
		String type=request.getParameter("type");
		String desc=request.getParameter("desc");
		dbconnection obj=new dbconnection();
		ResultSet rs=obj.selectdata("select * from resource where nameofresource='"+ name +"'");
				try {
					if(rs.next())
					{
						request.setAttribute("zc", "Resource Already added");
						RequestDispatcher rd=request.getRequestDispatcher("createnewresource.jsp?x="+netid);
						rd.forward(request, response);
					}else{
						//obj.modify("insert into resource(nameofresource,typeofresource,description) value ('"+ name +"','"+ type +"','"+ desc +"')");
						obj.addresource(name,type,desc);
						request.setAttribute("zc", "Resource added");
						RequestDispatcher rd=request.getRequestDispatcher("createnewresource.jsp?x="+netid);
						rd.forward(request, response);

					}
									} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

}
