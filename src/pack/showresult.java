package pack;

import java.sql.ResultSet;
import java.sql.SQLException;

public class showresult {
	
	private int examresult_id;
	private String examname;
	private String studentname;
	private String netid;
	private String result;
	public int getExamresult_id() {
		return examresult_id;
	}
	public void setExamresult_id(int examresult_id) {
		this.examresult_id = examresult_id;
	}
	public String getExamname() {
		return examname;
	}
	public void setExamname(String examname) {
		this.examname = examname;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getNetid() {
		return netid;
	}
	public void setNetid(String netid) {
		this.netid = netid;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}