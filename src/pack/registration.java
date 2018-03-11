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
 * Servlet implementation class registration
 */
@WebServlet("/registration")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String netid=request.getParameter("netid");
		String password=request.getParameter("password");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String yearjoined=request.getParameter("year");
		String role=request.getParameter("role");
		String major=request.getParameter("major");
		String program=request.getParameter("program");
		
		dbconnection obj=new dbconnection();
		
		if(yearjoined=="" && major=="" && program==""){
			System.out.println("In fs");
			ResultSet rs=obj.selectdata("select netid from fsregistration where netid='"+netid+"' ");
			try {
				if(rs.next()){
					
					request.setAttribute("zc", "*Netid already registered");;
               	  RequestDispatcher dispatch=request.getRequestDispatcher("registration.jsp");
                	  dispatch.forward(request,response);
				}
				else{
					//obj.modify("insert into fsregistration(netid,password,role,Firstname,Lastname) values('"+ netid +"','"+ password +"','"+ role +"','"+ firstname +"','"+ lastname +"')");
					obj.fsregistration(netid,password,role,firstname,lastname);
					response.sendRedirect("loginpage.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			ResultSet rs3=obj.selectdata("select netid from studentregistration where netid='"+netid+"'");
			try {
				if(rs3.next()){
					
					request.setAttribute("zc", "*Netid already registered");;
				  RequestDispatcher dispatch=request.getRequestDispatcher("registration.jsp");
					  dispatch.forward(request,response);
				}
				else{
					System.out.println("In s");
					//obj.modify("insert into studentregistration(netid,password,Firstname,Lastname,year_joined,role,major,program) values('"+ netid +"','"+ password +"','"+ firstname +"','"+ lastname +"','"+ yearjoined +"','"+ role +"','"+ major +"','"+ program +"')");
					obj.sregistration(netid,password,firstname,lastname,yearjoined,role,major,program);
					response.sendRedirect("loginpage.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		//response.sendRedirect("login.jsp");
	}

	}

