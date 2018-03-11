package pack;

import java.sql.*;

public class dbconnection {
	public void modify(String q)
	{
	    try
	         {
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	             
	        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
	        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
	         Statement st=con.createStatement();
	         st.execute(q);
	         }
	         catch(Exception ex)
	         {
	        	 System.out.println(ex.toString());          
	         }

	}

	public  ResultSet selectdata(String q)
	{
	    ResultSet rs=null;
	    try
	         {
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	             
	        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
	        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
	         Statement st=con.createStatement();
	         rs=st.executeQuery(q);
	         //System.out.println("Success2");
	         
	         }
	         catch(Exception ex)
	         {
	          
	         }
	       return rs;
	 }
	public boolean preparedStatement(String topicname,String topicpost,String date)
	{
	    try
	         {
	    	Class.forName("com.mysql.jdbc.Driver").newInstance();
	        
	        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
	        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
	         Statement st=con.createStatement();
	  System.out.println("date:"+date);
	  System.out.println("date:"+topicname);
	  System.out.println("date:"+topicpost);
		String insert = "insert into discussionboard(name,parentfeed_id,post,date) values ('"+ topicname +"','0','"+ topicpost +"','"+ date +"')";
		st.executeUpdate(insert);
		}
		
			catch (Exception e)
			
			{
			System.out.println(e);
			}
		return true;

	}
	
	public boolean preparedStatementReply(String board_id,String reply,String date)
	{
	    try
	         {
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	             
	        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
	        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
	        String value="insert into board_reply(board_id,reply,date) values (?,?,?)";
	         PreparedStatement st=con.prepareStatement(value);
	         st.setString(1,board_id);
	         st.setString(2,reply);
	         st.setString(3,date);
	         st.execute();
	         System.out.println("SSSTTT:"+st);
	         }
	         catch(Exception ex)
	         {
	        	 System.out.println(ex.toString());          
	         }
	    return true;

	}
	public  boolean addcourse(String csi,String coursename, String netid)
    {
    	try
    	{
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
            //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
             Statement st=con.createStatement();
		String insert = "insert into coursestaught(courseid,coursename,facultyid) values ('"+ csi +"','"+ coursename +"','"+ netid +"')";
		st.executeUpdate(insert);
		}
		
			catch (Exception e)
			
			{
			System.out.println(e);
			}
    	return true;
    }
	
	public  boolean addtopic(String topicname,String date, String netid)
    {
    	try
    	{
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
            //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
             Statement st=con.createStatement();
		String insert = "insert into topic(name,date,netid) values ('"+ topicname+"','"+ date +"','"+ netid +"')";
		st.executeUpdate(insert);
		}
		
			catch (Exception e)
			
			{
			System.out.println(e);
			}
    	return true;
    }
	
public  boolean addexam(String name,String date, String link,String netid)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
         Statement st=con.createStatement();
	String insert = "insert into exam(exam_name,date,link,facultyid) values ('"+ name +"','"+ date +"','"+ link +"','"+ netid +"')";
	st.executeUpdate(insert);
	}
	
		catch (Exception e)
		
		{
		System.out.println(e);
		}
	return true;
}

public  boolean addpost(String netid,String post, String cname,String ta,String fac,String cs)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
         Statement st=con.createStatement();
	String insert = "insert into facultypost(facultyid,post,course_name,ta,fac,cs) values ('"+ netid +"','"+ post +"','"+ cname +"','"+ ta +"','"+ fac +"','"+ cs +"')";
	st.executeUpdate(insert);
	}
	
		catch (Exception e)
		
		{
		System.out.println(e);
		}
	return true;
}

public  boolean reserveresource(String resourcename1,String date, String time,String netid)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
         Statement st=con.createStatement();
	String insert = "insert into reservedresource(resourcename,date,time,netid) value('"+ resourcename1 +"','"+ date +"','"+ time +"','"+ netid +"')";
	st.executeUpdate(insert);
	}
	
		catch (Exception e)
		
		{
		System.out.println(e);
		}
	return true;
}
public  boolean addresource(String name,String type, String desc)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
         Statement st=con.createStatement();
	String insert = "insert into resource(nameofresource,typeofresource,description,status) value ('"+ name +"','"+ type +"','"+ desc +"','A')";
	st.executeUpdate(insert);
	}
	
		catch (Exception e)
		
		{
		System.out.println(e);
		}
	return true;
}

public  boolean alumnipost(String name,String member, String founded,String link)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
         Statement st=con.createStatement();
	String insert = "insert into alumni(name,members,founded,link) value('"+ name +"','"+ member +"','"+ founded +"','"+ link +"')";
	st.executeUpdate(insert);
	}
	
		catch (Exception e)
		
		{
		System.out.println(e);
		}
	return true;
}

public  boolean postann(String ann,String id, String date)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
         Statement st=con.createStatement();
	String insert = "insert into announ(announcement,netid,date) values('"+ ann +"','"+ id +"','"+date+"')";
	st.executeUpdate(insert);
	}
	
		catch (Exception e)
		
		{
		System.out.println(e);
		}
	return true;
}

public  boolean postexamresult(String id,String result, String name,String netid)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
         Statement st=con.createStatement();
	String insert = "insert into examresult(studentname,result,examname,netid) values ('"+ id +"','"+ result +"','"+ name +"','"+ netid +"')";
	st.executeUpdate(insert);
	}
	
		catch (Exception e)
		
		{
		System.out.println(e);
		}
	return true;
}

public  boolean postjobs(String id,String link, String job,String date,String location)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
         Statement st=con.createStatement();
	String insert = "insert into jobs(netid,linkjob,jobs,date,location) values('"+ id +"','"+ link +"','"+ job +"','"+date+"','"+ location +"')";
	st.executeUpdate(insert);
	}
	
		catch (Exception e)
		
		{
		System.out.println(e);
		}
	return true;
}
public  boolean postnews(String id,String news, String date)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
         Statement st=con.createStatement();
	String insert = "insert into news(netid,news,date) values('"+ id +"','"+ news +"','"+ date +"')";
	st.executeUpdate(insert);
	}
	
		catch (Exception e)
		
		{
		System.out.println(e);
		}
	return true;
}
public  boolean fsregistration(String netid,String password, String role,String firstname,String lastname)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
         Statement st=con.createStatement();
	String insert = "insert into fsregistration(netid,password,role,Firstname,Lastname) values('"+ netid +"','"+ password +"','"+ role +"','"+ firstname +"','"+ lastname +"')";
	st.executeUpdate(insert);
	}
	
		catch (Exception e)
		
		{
		System.out.println(e);
		}
	return true;
}

public  boolean sregistration(String netid,String password, String firstname,String lastname,String yearjoined,String role,String major,String program)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
         Statement st=con.createStatement();
	String insert = "insert into studentregistration(netid,password,Firstname,Lastname,year_joined,role,major,program,status) values('"+ netid +"','"+ password +"','"+ firstname +"','"+ lastname +"','"+ yearjoined +"','"+ role +"','"+ major +"','"+ program +"','Candidate')";
	st.executeUpdate(insert);
	}
	
		catch (Exception e)
		
		{
		System.out.println(e);
		}
	return true;
}
public  boolean topicreply(String reply,String parentfeed, String name,String date)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
         Statement st=con.createStatement();
	String insert = "insert into discussionboard(post,parentfeed_id,name,date) values ('"+reply+"','"+parentfeed+"','"+name+"','"+date+"')";
	st.executeUpdate(insert);
	}
	
		catch (Exception e)
		
		{
		System.out.println(e);
		}
	return true;
}

public  boolean deleteannoun(String id)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
         Statement st=con.createStatement();
	String delete = "delete from announ where announ_id='"+ id +"'";
	st.executeUpdate(delete);
	}
	
		catch (Exception e)
		
		{
		System.out.println(e);
		}
	return true;
}

public  boolean deletejob(String id)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
         Statement st=con.createStatement();
	String delete = "delete from jobs where job_id='"+ id +"'";
	st.executeUpdate(delete);
	}
	
		catch (Exception e)
		
		{
		System.out.println(e);
		}
	return true;
}

public  boolean deletnews(String id)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
         Statement st=con.createStatement();
	String delete = "delete from news where news_id='"+ id +"'";
	st.executeUpdate(delete);
	}
	
		catch (Exception e)
		
		{
		System.out.println(e);
		}
	return true;
}
public  boolean updatestudentprofile(String pwd,String advisor,String email,String phone,String id)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
         Statement st=con.createStatement();
	String update = "update studentregistration set password='"+ pwd +"',advisor='"+ advisor +"',email='"+ email +"',phone='"+ phone +"' where netid='"+ id+"'";
	st.executeUpdate(update);
	}
	
		catch (Exception e)
		
		{
		System.out.println(e);
		}
	return true;
}

public  boolean examregister(String exam,String netid,String name)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/se_termproject","root","root");
        //Connection con=DriverManager.getConnection("jdbc:mysql://sebank.cwfokv4esrag.us-west-2.rds.amazonaws.com:3306/sebank","root","root123$");
         Statement st=con.createStatement();
	String insert = "insert into studentexamsignup(nameofexam,netid,id) values ('"+exam+"','"+netid+"','"+name+"')";
	st.executeUpdate(insert);
	}
	
		catch (Exception e)
		
		{
		System.out.println(e);
		}
	return true;
}






}