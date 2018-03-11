package pack;

import java.sql.ResultSet;
import java.sql.SQLException;

public class courses {
	private int course_id;
	private String course_csi;
	private String course_name;
	
	public void setcourseid (int course_id) {
		this.course_id = course_id;
	}
	
	public int getcourseid() {
		return course_id;
	}
	public void setcoursecsi (String course_csi) {
		this.course_csi = course_csi;
	}
	
	public String getcoursecsi() {
		return course_csi;
		
	}public void setcoursename (String course_name) {
		this.course_name = course_name;
	}
	
	public String getcoursename() {
		return course_name;
	}
	
}
