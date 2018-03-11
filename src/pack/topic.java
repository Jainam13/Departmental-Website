package pack;

import java.sql.ResultSet;
import java.sql.SQLException;

public class topic {

	private String name;
	private String date;
	private String netid;
	private String post;
	private String parentfeed_id;
	private int board_id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNetid() {
		return netid;
	}
	public void setNetid(String netid) {
		this.netid = netid;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getParentfeed_id() {
		return parentfeed_id;
	}
	public void setParentfeed_id(String parentfeed_id) {
		this.parentfeed_id = parentfeed_id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	
	
}