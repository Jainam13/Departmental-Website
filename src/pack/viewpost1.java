package pack;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class viewpost1
 */
@WebServlet("/viewpost1")
public class viewpost1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewpost1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String topicname=session.getAttribute("topic").toString();
		System.out.println("Topicname:"+topicname);
		//String a1=(String) session.getAttribute("hashtag");
		String a2=request.getParameter("content");
		System.out.println("A2:"+a2);
		int m=Integer.parseInt(request.getParameter("garbage"));
		System.out.println("GG:"+m);
		if(a2.isEmpty() || a2.trim().length() == 0)
		{
			System.out.println("I IM IN HERE ok");
			Alist ad= new Alist();
			ArrayList<String> a4 = ad.checkpost(topicname);
			System.out.println("A4:"+a4);
			String formatedString = a4.toString()
				    .replace(",", "")  //remove the commas
				    .replace("[", "")  //remove the right bracket
				    .replace("]", "")  //remove the left bracket
				    .trim();           //remove trailing spaces from partially initialized arrays
			session.setAttribute("posts", formatedString);
			request.setAttribute("Etrror", "Content cannot be empty.");
            //getServletContext().getRequestDispatcher("/view.jsp").forward(request, response);
            response.sendRedirect("viewtopicpost.jsp?x="+topicname);
		}
		else
			
		{
			System.out.println("I M IN HERE");
			System.out.println(topicname);
			System.out.println(a2);
			System.out.println(m);
			Alist ad= new Alist();
	dbconnection db=new dbconnection();
		//db.preparedStatement(topicname, a2, m);	
		ArrayList<String> a4 = ad.checkpost(topicname);
		String formatedString = a4.toString()
			    .replace(",", "")  //remove the commas
			    .replace("[", "")  //remove the right bracket
			    .replace("]", "")  //remove the left bracket
			    .trim();           //remove trailing spaces from partially initialized arrays
		
		//session.setAttribute("viewpost", a2);
		//request.setAttribute("viewpost", a2);
		//System.out.println("Here??");
		String rr = request.getParameter("reply");
		session.setAttribute("reply", rr);
		session.setAttribute("posts", formatedString);
		//getServletContext().getRequestDispatcher("/view.jsp").forward(request, response);
		response.sendRedirect("viewtopicpost.jsp?x="+topicname);
		//System.out.println("I hope!!!");
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
