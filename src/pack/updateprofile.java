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

/**
 * Servlet implementation class updateprofile
 */
@WebServlet("/updateprofile")
public class updateprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateprofile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String netid=request.getParameter("name");
		String password=request.getParameter("password");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		dbconnection obj=new dbconnection();
		obj.modify("update fsregistration set netid='"+ netid +"',password='"+ password +"',Firstname='"+ firstname +"',Lastname='"+ lastname +"' where netid='"+ netid +"'");
		request.setAttribute("zc", "Updated Profile");
		//dbconnection obj=new dbconnection();
		ResultSet rs=obj.selectdata("select role from fsregistration where netid='"+ netid +"'");
		try {
			while(rs.next())
			{
				String role=rs.getString(1);
				if(role.equals("Staff"))
				{
					RequestDispatcher rd=request.getRequestDispatcher("stafflogin.jsp");
					rd.forward(request, response);
				}else{
					
				}RequestDispatcher rd=request.getRequestDispatcher("Facultylogin.jsp");
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
