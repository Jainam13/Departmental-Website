package pack;

import java.sql.ResultSet;
import java.sql.SQLException;

public class post {

	private String post;
	private String facultyid;
	private String coursename;
	
	
	public void setpost (String post) {
		this.post = post;
	}
	
	public String getpost() {
		return post;
	}

	public String getFacultyid() {
		return facultyid;
	}

	public void setFacultyid(String facultyid) {
		this.facultyid = facultyid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
}
