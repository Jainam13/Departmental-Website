package pack;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
public class Alist {
	
	public ArrayList<courses> Getcourse () {
		ArrayList<courses> courseretrieve = new ArrayList<courses>();
		try {
			dbconnection obj=new dbconnection();
			ResultSet rs=obj.selectdata("select * from course");
			while (rs.next()) {
				courses course = new courses();
				course.setcourseid(rs.getInt("course_id"));
				course.setcoursecsi(rs.getString("course_csi"));
				course.setcoursename(rs.getString("course_name"));
				courseretrieve.add(course);
			}
			return courseretrieve;
		}
		catch (Exception ex) {
			return courseretrieve;
		}
	}
	
	public ArrayList<coursetaught> Getcoursedata (String netid) {
		ArrayList<coursetaught> coursetaughtretrieve = new ArrayList<coursetaught>();
		try {
			dbconnection obj=new dbconnection();
			ResultSet rs=obj.selectdata("select * from coursestaught where facultyid='"+ netid +"'");
			System.out.println("IN ALIST:"+rs);
			while (rs.next()) {
				coursetaught coursetaught = new coursetaught();
				coursetaught.setFacultyid(rs.getString("facultyid"));
				coursetaught.setCourseid(rs.getString("courseid"));
				coursetaught.setCoursename(rs.getString("coursename"));
				coursetaughtretrieve.add(coursetaught);
			}
			return coursetaughtretrieve;
		}
		catch (Exception ex) {
			return coursetaughtretrieve;
		}
	
	}
	
	
	public ArrayList<resource> Getresource () {
		ArrayList<resource> resourceretrieve = new ArrayList<resource>();
		try {
			dbconnection obj=new dbconnection();
			ResultSet rs=obj.selectdata("select * from resource where status='A'");
			while (rs.next()) {
				resource resource = new resource();
				resource.setresourceid(rs.getInt("resource_id"));
				resource.setnameofresource(rs.getString("nameofresource"));
				resource.settypeofresource(rs.getString("typeofresource"));
				resourceretrieve.add(resource);
			}
			return resourceretrieve;
		}
		catch (Exception ex) {
			return resourceretrieve;
		}
	}
	
	
	public ArrayList<reservedresource> Getreservedresource (String netid) {
		ArrayList<reservedresource> reservedresourceretrieve = new ArrayList<reservedresource>();
		try {
			System.out.println("NETID IN RR:"+netid);
			dbconnection obj=new dbconnection();
			ResultSet rs=obj.selectdata("select * from reservedresource where netid='"+ netid +"'");
			System.out.println("RS IN RR:"+rs);
			while (rs.next()) {
				reservedresource resource = new reservedresource();
				resource.setResourcename(rs.getString("resourcename"));
				resource.setDate(rs.getString("date"));
				resource.setTime(rs.getString("time"));
				resource.setReservedresource_id(rs.getInt("reservedresource_id"));
				reservedresourceretrieve.add(resource);
			}
			System.out.println("Resource IN RR:"+reservedresourceretrieve);
			return reservedresourceretrieve;
		}
		catch (Exception ex) {
			return reservedresourceretrieve;
		}
	}
	
	public ArrayList<post> Getpost (String netid) {
		ArrayList<post> postretrieve = new ArrayList<post>();
		try {
			dbconnection obj=new dbconnection();
			ResultSet rs=obj.selectdata("select * from facultypost where facultyid='"+netid+"' ORDER BY facultypost_id DESC");
			System.out.println("RSSSSS:"+rs);
			while (rs.next()) {
				post post = new post();
				post.setpost(rs.getString("post"));
				post.setCoursename(rs.getString("course_name"));
				postretrieve.add(post);
				System.out.println("POOOOOOOST:"+postretrieve);
			}
			return postretrieve;
		}
		catch (Exception ex) {
			return postretrieve;
		}
	}
	public ArrayList<showresult> Getresult (String netid) {
		ArrayList<showresult> resultretrieve = new ArrayList<showresult>();
		try {
			dbconnection obj=new dbconnection();
			ResultSet rs=obj.selectdata("select * from examresult where netid='"+ netid +"'");
			System.out.println("RSSSSS:"+rs);
			while (rs.next()) {
				showresult result = new showresult();
				result.setExamname(rs.getString("examname"));
				result.setStudentname(rs.getString("studentname"));
				result.setExamresult_id(rs.getInt("examresult_id"));
				result.setNetid(rs.getString("netid"));
				result.setResult(rs.getString("result"));
				resultretrieve.add(result);
				System.out.println("POOOOOOOST:"+resultretrieve);
			}
			return resultretrieve;
		}
		catch (Exception ex) {
			return resultretrieve;
		}
	}
	
	public ArrayList<showresult> Getresultedit (String examname,String name) {
		ArrayList<showresult> resultedit = new ArrayList<showresult>();
		try {
			dbconnection obj=new dbconnection();
			ResultSet rs=obj.selectdata("select * from examresult where examname='"+ examname +"' and studentname='"+ name +"'");
			System.out.println("RSSSSS:"+rs);
			while (rs.next()) {
				showresult result = new showresult();
				result.setExamname(rs.getString("examname"));
				result.setStudentname(rs.getString("studentname"));
				result.setExamresult_id(rs.getInt("examresult_id"));
				result.setNetid(rs.getString("netid"));
				result.setResult(rs.getString("result"));
				resultedit.add(result);
				System.out.println("POOOOOOOST:"+resultedit);
			}
			return resultedit;
		}
		catch (Exception ex) {
			return resultedit;
		}
	}
	
	public ArrayList<exam> Getexam (String netid) {
		ArrayList<exam> examretrieve = new ArrayList<exam>();
		try {
			dbconnection obj=new dbconnection();
			System.out.println(netid);
			ResultSet rs=obj.selectdata("select * from exam where facultyid='"+ netid +"' ORDER BY date ASC");
			System.out.println("RSSSSS:"+rs);
			while (rs.next()) {
				exam exam = new exam();
				exam.setExam_name(rs.getString("exam_name"));
				exam.setDate(rs.getString("date"));
				exam.setLink(rs.getString("link"));
				exam.setFacultyid(rs.getString("facultyid"));
				examretrieve.add(exam);
				System.out.println("POOOOOOOST:"+examretrieve);
			}
			return examretrieve;
		}
		catch (Exception ex) {
			return examretrieve;
		}
	}
	
	public ArrayList<studentexamsignup> Getstudentexam (String netid) {
		ArrayList<studentexamsignup> studentexamretrieve = new ArrayList<studentexamsignup>();
		try {
			dbconnection obj=new dbconnection();
			System.out.println(netid);
			ResultSet rs=obj.selectdata("select * from studentexamsignup where nameofexam='"+ netid +"'");
			System.out.println("RSSSSS:"+rs);
			while (rs.next()) {
				studentexamsignup studentexam = new studentexamsignup();
				studentexam.setNameofexam(rs.getString("nameofexam"));
				studentexam.setStudentexam_id(rs.getInt("studentexam_id"));
				studentexam.setNetid(rs.getString("netid"));
				studentexamretrieve.add(studentexam);
				//System.out.println("POOOOOOOST:"+studentexamretrieve);
			}
			return studentexamretrieve;
		}
		catch (Exception ex) {
			return studentexamretrieve;
		}
	}
	
	
	
	public ArrayList<alumni> Getalumni () {
		ArrayList<alumni> alumniretrieve = new ArrayList<alumni>();
		try {
			dbconnection obj=new dbconnection();
			ResultSet rs=obj.selectdata("select * from alumni");
			System.out.println("RSSSSS:"+rs);
			while (rs.next()) {
				alumni alumni = new alumni();
				alumni.setalumniid(rs.getInt("alumni_id"));
				alumni.setname(rs.getString("name"));
				alumni.setmembers(rs.getString("members"));
				alumni.setfounded(rs.getString("founded"));
				alumni.setlink(rs.getString("link"));
				alumniretrieve.add(alumni);
				System.out.println("POOOOOOOST:"+alumniretrieve);
			}
			return alumniretrieve;
		}
		catch (Exception ex) {
			return alumniretrieve;
		}
	}
	
	public ArrayList<announ> Getannoun() {
		ArrayList<announ> announretrieve = new ArrayList<announ>();
		try {
			//System.out.println("bid in Alist:"+netid);
			dbconnection obj=new dbconnection();
			ResultSet rs=obj.selectdata("select * from announ");
			System.out.println("RSSSSS:"+rs);
			while (rs.next()) {
				announ bd = new announ();
				bd.setAnnoun_id(rs.getInt("announ_id"));
				bd.setAnnouncement(rs.getString("announcement"));
				bd.setNetid(rs.getString("netid"));
				bd.setDate(rs.getString("date"));
				announretrieve.add(bd);
				System.out.println("POOOOOOOST:"+announretrieve);
			}
			return announretrieve;
		}
		catch (Exception ex) {
			return announretrieve;
		}
	}
	public ArrayList<topic> Gettopic() {
		ArrayList<topic> topicretrieve = new ArrayList<topic>();
		try {
			//System.out.println("bid in Alist:"+netid);
			dbconnection obj=new dbconnection();
			ResultSet rs=obj.selectdata("select * from topic");
			System.out.println("RSSSSS:"+rs);
			while (rs.next()) {
				topic topic = new topic();
				topic.setName(rs.getString("name"));
				topic.setDate(rs.getString("date"));
				topic.setNetid(rs.getString("netid"));
				
				topicretrieve.add(topic);
				System.out.println("POOOOOOOST:"+topicretrieve);
			}
			return topicretrieve;
		}
		catch (Exception ex) {
			return topicretrieve;
		}
	}
	
	public ArrayList<topic> Gettopicpost(String topicname) {
		ArrayList<topic> topicretrieve = new ArrayList<topic>();
		try {
			//System.out.println("bid in Alist:"+netid);
			dbconnection obj=new dbconnection();
			ResultSet rs=obj.selectdata("select * from discussionboard where name='"+ topicname +"' and parentfeed_id='0'");
			System.out.println("RSSSSS:"+rs);
			while (rs.next()) {
				topic topic = new topic();
				topic.setName(rs.getString("name"));
				topic.setDate(rs.getString("date"));
				topic.setPost(rs.getString("post"));
				topic.setBoard_id(rs.getInt("board_id"));
				topicretrieve.add(topic);
				System.out.println("POOOOOOOST:"+topicretrieve);
			}
			return topicretrieve;
		}
		catch (Exception ex) {
			return topicretrieve;
		}
	}
	public ArrayList<topic> Getreply(String post,String id) {
		ArrayList<topic> topicretrieve = new ArrayList<topic>();
		try {
			System.out.println("bid in Alist:"+id);
			dbconnection obj=new dbconnection();
			ResultSet rs=obj.selectdata("select * from discussionboard where name='"+ post +"' and parentfeed_id='"+ id +"'");
			System.out.println("RSSSSS:"+rs);
			while (rs.next()) {
				topic topic = new topic();
				topic.setName(rs.getString("name"));
				topic.setDate(rs.getString("date"));
				topic.setPost(rs.getString("post"));
				topic.setBoard_id(rs.getInt("board_id"));
				topicretrieve.add(topic);
				System.out.println("POOOOOOOST:"+topicretrieve);
			}
			return topicretrieve;
		}
		catch (Exception ex) {
			return topicretrieve;
		}
	}
	
	public ArrayList<announ> Getnews() {
		ArrayList<announ> announretrieve = new ArrayList<announ>();
		try {
			//System.out.println("bid in Alist:"+netid);
			dbconnection obj=new dbconnection();
			ResultSet rs=obj.selectdata("select * from news");
			System.out.println("RSSSSS:"+rs);
			while (rs.next()) {
				announ bd = new announ();
				bd.setNews_id(rs.getInt("news_id"));
				bd.setNetid(rs.getString("netid"));
				bd.setNews(rs.getString("news"));
				
				bd.setDate(rs.getString("date"));
				announretrieve.add(bd);
				System.out.println("POOOOOOOST:"+announretrieve);
			}
			return announretrieve;
		}
		catch (Exception ex) {
			return announretrieve;
		}
	}
	public ArrayList<announ> Getjob() {
		ArrayList<announ> announretrieve = new ArrayList<announ>();
		try {
			//System.out.println("bid in Alist:"+netid);
			dbconnection obj=new dbconnection();
			ResultSet rs=obj.selectdata("select * from jobs");
			System.out.println("RSSSSS:"+rs);
			while (rs.next()) {
				announ bd = new announ();
				bd.setJobs_id(rs.getInt("job_id"));
				bd.setLinkjob(rs.getString("linkjob"));
				bd.setLocation(rs.getString("location"));
				bd.setNetid(rs.getString("netid"));
				
				bd.setJobs(rs.getString("jobs"));
				bd.setDate(rs.getString("date"));
				announretrieve.add(bd);
				System.out.println("POOOOOOOST:"+announretrieve);
			}
			return announretrieve;
		}
		catch (Exception ex) {
			return announretrieve;
		}
	}
	
public ArrayList<String> checkpost(String name) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} 
		catch (ClassNotFoundException  e) {
			e.printStackTrace();
		}
		try
		{
			System.out.println("I M IN Alist");
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select * from discussionboard where name='" + name + "' ORDER BY date DESC";
		Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/se_termproject", "root", "root");;
		
		PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
		String sql1 = "select * from discussionboard where name='" + name + "' ORDER BY date DESC";
		 ResultSet rs= statement.executeQuery(sql); 
		ArrayList<String> post = new ArrayList<String>();
		 while (rs.next())

			{
				StringBuilder val = new StringBuilder();
				for (int j = 1; j <= rs.getMetaData().getColumnCount(); j++) {

					val.append(rs.getString(j) + ",");

				}
				post.add(val.toString());
				System.out.println("POST SU:"+post);
			}
		 
		 
		 ResultSet result = statement.executeQuery(sql1);
		
		 while(result.next())
		 {
//			 /System.out.println("INT VALUE:"+result.getInt(1));
			if(result.getInt(3)==0) {
			list.add("<h4>Question: "+result.getString("post")+"</h4>");
			list.add("<form action='viewpost1?x=name' method='post'>");
			list.add("Give a reply:  <input type='text' name='content'>");
			System.out.println("INT VALUE:"+result.getInt(1));
			list.add("<input type='hidden' value="+result.getInt(1)+" name='flag'> <input type='submit' value='Reply'> </form><br>");
			for(int count=0;count<post.size();count++){
				String t[] = null;
				t = post.get(count).split(",");
				System.out.println("t:"+t[2]);
				System.out.println("t:"+t[1]);
					if(result.getInt(1)==(Integer.parseInt(t[2]))) {
						list.add("Reply: "+t[1]+"<br>");
						
					}
				}
			
			list.add("<br>");
			 }
		 }
	
		 return (list);
		 
		 
		 
		 
		
		} 
		catch (SQLException e)

		{
			e.printStackTrace();
		}
		return null;
}
	
	public alumnidata Getalumnidata (int id) {
		alumnidata alumni = new alumnidata();
		try {
			dbconnection obj=new dbconnection();
			ResultSet rs=obj.selectdata("select * from alumni where alumni_id='"+ id +"'");
			System.out.println("RSSSSS:"+rs);
			while (rs.next()) {
				
				alumni.setalumniid(rs.getInt("alumni_id"));
				alumni.setname(rs.getString("name"));
				alumni.setmembers(rs.getString("members"));
				alumni.setfounded(rs.getString("founded"));
				alumni.setlink(rs.getString("link"));
				
				System.out.println("POOOOOOOST:"+alumni);
			}
			return alumni;
		}
		catch (Exception ex) {
			return alumni;
		}
	}
	
	
	
	public fsregistration Getfsdata (String id) {
		fsregistration fs = new fsregistration();
		try {
			dbconnection obj=new dbconnection();
			ResultSet rs=obj.selectdata("select * from fsregistration where netid='"+ id +"'");
			System.out.println("RSSSSS:"+rs);
			while (rs.next()) {
				
				fs.setFirstname(rs.getString("Firstname"));
				fs.setLastname(rs.getString("Lastname"));
				fs.setNetid(rs.getString("netid"));
				fs.setPassword(rs.getString("password"));
				fs.setRole(rs.getString("role"));
				
				System.out.println("POOOOOOOST:"+fs);
			}
			return fs;
		}
		catch (Exception ex) {
			return fs;
		}
	}
	public ArrayList<studentregistration> GetPhDstudents () {
		ArrayList<studentregistration> PhDretrieve = new ArrayList<studentregistration>();
		try {
			dbconnection obj=new dbconnection();
			ResultSet rs=obj.selectdata("select * from studentregistration where program='PhD'");
			System.out.println("RSSSSS:"+rs);
			while (rs.next()) {
				studentregistration PhD = new studentregistration();
				PhD.setNetid(rs.getString("netid"));
				PhD.setFirstname(rs.getString("Firstname"));
				PhD.setLastname(rs.getString("Lastname"));
				PhD.setRole(rs.getString("role"));
				PhD.setMajor(rs.getString("major"));
				PhD.setPassword(rs.getString("password"));
				PhD.setProgram(rs.getString("program"));
				PhD.setYear_joined(rs.getString("year_joined"));
				PhDretrieve.add(PhD);
				System.out.println("POOOOOOOST:"+PhDretrieve);
			}
			return PhDretrieve;
		}
		catch (Exception ex) {
			return PhDretrieve;
		}
	}
	public ArrayList<studentregistration> GetspecificPhDstudents (String netid) {
		ArrayList<studentregistration> PhDretrieve = new ArrayList<studentregistration>();
		try {
			dbconnection obj=new dbconnection();
			ResultSet rs=obj.selectdata("select * from studentregistration where netid='"+ netid +"'");
			System.out.println("RSSSSS:"+rs);
			while (rs.next()) {
				studentregistration PhD = new studentregistration();
				PhD.setNetid(rs.getString("netid"));
				PhD.setFirstname(rs.getString("Firstname"));
				PhD.setLastname(rs.getString("Lastname"));
				PhD.setRole(rs.getString("role"));
				PhD.setMajor(rs.getString("major"));
				PhD.setPassword(rs.getString("password"));
				PhD.setProgram(rs.getString("program"));
				PhD.setYear_joined(rs.getString("year_joined"));
				PhD.setStatus(rs.getString("status"));
				PhDretrieve.add(PhD);
				System.out.println("POOOOOOOST:"+PhDretrieve);
			}
			return PhDretrieve;
		}
		catch (Exception ex) {
			return PhDretrieve;
		}
	}
	
	

	public String role(String netid){
		dbconnection db=new dbconnection();
		
		ResultSet rs=db.selectdata("select role from fsregistration where netid='"+ netid +"' ");
		//System.out.println("R in ALIST:"+rs);
		String role = null;
		try {
			while(rs.next())
			{
				role=rs.getString(1);
			//	System.out.println("Role in Alist:"+role);
			
			}
		return role;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;
	}
}