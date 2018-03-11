package pack;

import java.sql.ResultSet;
import java.sql.SQLException;

public class reservedresource {
	private int reservedresource_id;
	private String resourcename;
	private String date;
	private String time;
	private String netid;
	public String getResourcename() {
		return resourcename;
	}
	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getNetid() {
		return netid;
	}
	public void setNetid(String netid) {
		this.netid = netid;
	}
	public int getReservedresource_id() {
		return reservedresource_id;
	}
	public void setReservedresource_id(int reservedresource_id) {
		this.reservedresource_id = reservedresource_id;
	}
	
}