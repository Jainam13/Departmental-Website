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
 * Servlet implementation class addcourse
 */
@WebServlet("/addcourse")
public class addcourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addcourse() {
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
		 System.out.println("Netid:"+netid);
		 String csi=request.getParameter("x");
		 System.out.println("id:"+csi);
		dbconnection obj=new dbconnection();
		 ResultSet rs=obj.selectdata("SELECT course_name FROM course WHERE course_csi='"+ csi +"'");
		 System.out.println("rs:"+rs);
		 ResultSet rs4=obj.selectdata("select * from coursestaught where courseid='"+ csi +"'");
		 System.out.println("rs4:"+rs4);
		 try {
			if(rs4.next())
			 {
				request.setAttribute("zc", "*Course already added");;
          	  RequestDispatcher dispatch=request.getRequestDispatcher("coursedetails");
           	  dispatch.forward(request,response);
			 }else{
				 while(rs.next())
				 {
					 String coursename;
					 coursename=rs.getString(1);
					 //obj.modify("insert into coursestaught(courseid,coursename,facultyid) values ('"+ csi +"','"+ coursename +"','"+ netid +"')");
					 obj.addcourse(csi, coursename, netid);
					 request.setAttribute("zc", "Course added");;
		          	  RequestDispatcher dispatch=request.getRequestDispatcher("coursedetails");
		           	  dispatch.forward(request,response);
				 }
			 }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 System.out.println("RS:"+rs);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
