package pack;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class checklogin
 */
@WebServlet("/checklogin")
public class checklogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checklogin() {
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
          String l=request.getParameter("netid");
          String p=request.getParameter("password");
          if(l.equals("admin") && p.equals("admin"))
          {
              response.sendRedirect("welcomeadmin.jsp");
          }
          else 
          {
              dbconnection obj=new dbconnection();
              try
              {
              ResultSet rs=obj.selectdata("select * from studentregistration where netid='"+ l +"' and password='"+ p +"'");
              
              if(rs.next())
               {
                   s.setAttribute("id", rs.getString("netid"));
                   s.setAttribute("name", rs.getString("Firstname"));
                  // System.out.println(s.getAttribute("name"));
                   response.sendRedirect("studentlogin.jsp");
               }
              else
               {
                  ResultSet rs1=obj.selectdata("select * from fsregistration where netid='"+ l +"' and password='"+ p +"' and role='Faculty'");
                   if(rs1.next())
                   {
                    s.setAttribute("id", rs1.getString("netid"));  
                    s.setAttribute("name", rs1.getString("Firstname"));
                    response.sendRedirect("Facultylogin.jsp");
                   }
                   else {
                	   ResultSet rs2=obj.selectdata("select * from fsregistration where netid='"+ l +"' and password='"+ p +"' and role='Staff'");
                       if(rs2.next())
                       {
                        s.setAttribute("id", rs2.getString("netid"));   
                        s.setAttribute("name", rs2.getString("Firstname"));
                        
                        response.sendRedirect("stafflogin.jsp");
                       }   
                   
                   else
                   {
                	   request.setAttribute("zc", "*username or password doesnt match");;
                 	  RequestDispatcher dispatch=request.getRequestDispatcher("loginpage.jsp");
                  	  dispatch.include(request,response);
                   }
                   }
              }
              }
              catch(Exception ex)
              {
                  
              }
          }
     }
	}


