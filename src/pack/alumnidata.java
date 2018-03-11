package pack;

import java.sql.ResultSet;
import java.sql.SQLException;

public class alumnidata {

	private int alumniid;
	private String name;
	private String members;
	private String founded;
	private String link;
	
	public void setalumniid (int id) {
		this.alumniid = id;
	}
	
	public int getalumniid() {
		return alumniid;
	}
	public void setname (String name) {
		this.name = name;
	}
	
	public String getname() {
		return name;
	}
	public void setmembers (String members) {
		this.members = members;
	}
	
	public String getmembers() {
		return members;
		
	}
	public void setfounded (String founded) {
		this.founded = founded;
	}
	
	public String getfounded() {
		return founded;
	}
	public void setlink (String link) {
		this.link = link;
	}
	
	public String getlink() {
		return link;
	}
	
}
