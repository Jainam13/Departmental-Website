package pack;

import java.sql.ResultSet;
import java.sql.SQLException;

public class studentexamsignup {
	private int studentexam_id;
	private String nameofexam;
	private String netid;
	public int getStudentexam_id() {
		return studentexam_id;
	}
	public void setStudentexam_id(int studentexam_id) {
		this.studentexam_id = studentexam_id;
	}
	public String getNameofexam() {
		return nameofexam;
	}
	public void setNameofexam(String nameofexam) {
		this.nameofexam = nameofexam;
	}
	public String getNetid() {
		return netid;
	}
	public void setNetid(String netid) {
		this.netid = netid;
	}
}