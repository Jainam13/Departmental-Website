package pack;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import pack.dbconnection;

public class dbconnectionTest {

	static boolean test;
	static String uname;
	static String pwd;
	static dbconnection db;
	@BeforeClass
	public static void setUp() throws Exception {
		// TODO Auto-generated method stub
		//All set up activity goes here. e.g. setup db connections etc.
		Connection conn = null;
		Statement s = null;
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/se_termproject", "root", "root");
			s = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		db = new dbconnection();
		uname = "JAINAM";
		pwd="jainam";
	}

	


	@Test
	public void testPreparedStatement() {
		boolean success=db.preparedStatement(pwd, pwd,uname);
		Assert.assertEquals(true, success);
	}

	@Test
	public void testaddtopic() {
		boolean success=db.addtopic(pwd, pwd,uname);
		Assert.assertEquals(true, success);
	}
	
	@Test
	public void testPreparedStatementReply() {
		boolean success=db.preparedStatementReply(uname, pwd, pwd);
		Assert.assertEquals(true, success);
	}

	@Test
	public void testAddcourse() {
		boolean success=db.addcourse(uname, pwd, pwd);
		Assert.assertEquals(true, success);
	}

	@Test
	public void testAddexam() {
		boolean success=db.addexam(uname, uname, pwd, pwd);
		Assert.assertEquals(true, success);
	}

	@Test
	public void testAddpost() {
		boolean success=db.addpost(uname, pwd, pwd,uname,uname,pwd);
		Assert.assertEquals(true, success);
	}

	@Test
	public void testReserveresource() {
		boolean success=db.reserveresource(pwd, pwd, uname, uname);
		Assert.assertEquals(true, success);
	}

	@Test
	public void testAddresource() {
		boolean success=db.addresource(pwd, uname, pwd);
		Assert.assertEquals(true, success);
	}

	@Test
	public void testAlumnipost() {
		boolean success=db.alumnipost(pwd, uname, pwd, pwd);
		Assert.assertEquals(true, success);
	}

	@Test
	public void testPostann() {
		boolean success=db.postann(uname, pwd, pwd);
		Assert.assertEquals(true, success);
	}

	@Test
	public void testPostexamresult() {
		boolean success=db.postexamresult(uname, pwd, uname, pwd);
		Assert.assertEquals(true, success);
	}

	@Test
	public void testPostjobs() {
		boolean success=db.postjobs(pwd, uname, uname, pwd, pwd);
		Assert.assertEquals(true, success);
	}

	@Test
	public void testPostnews() {
		boolean success=db.postnews(uname, pwd, pwd);
		Assert.assertEquals(true, success);
	}

	@Test
	public void testFsregistration() {
		boolean success=db.fsregistration(uname, pwd, uname, uname, pwd);
		Assert.assertEquals(true, success);
	}

	@Test
	public void testSregistration() {
		boolean success=db.sregistration(pwd, uname, pwd, uname, uname, pwd, pwd,uname);
		Assert.assertEquals(true, success);
	}

	@Test
	public void testTopicreply() {
		boolean success=db.topicreply(pwd, pwd, uname,pwd);
		Assert.assertEquals(true, success);
	}

	@Test
	public void testDeleteannoun() {
		boolean success=db.deleteannoun(pwd);
		Assert.assertEquals(true, success);
	}

	@Test
	public void testDeletejob() {
		boolean success=db.deletejob(pwd);
		Assert.assertEquals(true, success);
	}

	@Test
	public void testDeletnews() {
		boolean success=db.deletnews(pwd);
		Assert.assertEquals(true, success);
	}
	@Test
	public void testupdatestudentprofile() {
		boolean success=db.updatestudentprofile(pwd,uname,uname,pwd,pwd);
		Assert.assertEquals(true, success);
	}
	
	@Test
	public void testexamregister() {
		boolean success=db.examregister(pwd,uname,uname);
		Assert.assertEquals(true, success);
	}
	
}
