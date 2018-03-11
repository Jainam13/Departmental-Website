package pack;

import java.sql.ResultSet;
import java.sql.SQLException;

public class discussion {
	private int boardpost_id;
	private int board_id;
	private String board_name;
	private String post;
	private String reply;
	private String netid;
	public int getBoardpost_id() {
		return boardpost_id;
	}
	public void setBoardpost_id(int boardpost_id) {
		this.boardpost_id = boardpost_id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getNetid() {
		return netid;
	}
	public void setNetid(String netid) {
		this.netid = netid;
	}
	
}