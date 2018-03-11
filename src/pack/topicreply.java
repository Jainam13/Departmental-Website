package pack;

import java.io.IOException;
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
 * Servlet implementation class topicreply
 */
@WebServlet("/topicreply")
public class topicreply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public topicreply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String reply=request.getParameter("reply");
		System.out.println("parentfeed:"+reply);
		String parentfeed=request.getParameter("post");
		System.out.println("parentfeed:"+parentfeed);
		String name=request.getParameter("id");
		System.out.println("name:"+name);
		dbconnection db=new dbconnection();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		//db.modify("insert into discussionboard(post,parentfeed_id,name) values ('"+reply+"','"+parentfeed+"','"+name+"')");
		db.topicreply(reply,parentfeed,name,dateFormat.format(date));
		RequestDispatcher rd=request.getRequestDispatcher("viewtopicpost?x="+name+"&reply="+reply);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
