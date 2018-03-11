package pack;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class viewann
 */
@WebServlet("/viewann")
public class viewann extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewann() {
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
		String id=s.getAttribute("id").toString();
		System.out.println(id);
		ArrayList<announ> ann = new ArrayList<announ>();
		Alist a=new Alist();
		dbconnection db=new dbconnection();
		ann=a.Getannoun();
		System.out.println(ann);
		request.setAttribute("announ", ann);
		ResultSet rs=db.selectdata("select Firstname from fsregistration where netid='"+ id +"'");
		System.out.println("I M IN");
		try {
			while(rs.next())
			{
				System.out.println("I M IN");
				String name=rs.getString(1);
				RequestDispatcher rd=request.getRequestDispatcher("viewann.jsp?name="+name);
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
