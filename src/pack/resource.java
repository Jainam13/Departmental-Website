package pack;

import java.sql.ResultSet;
import java.sql.SQLException;

public class resource {
	private int resource_id;
	private String nameofresource;
	private String typeofresource;
	
	public void setresourceid (int resource_id) {
		this.resource_id = resource_id;
	}
	
	public int getresourceid() {
		return resource_id;
	}
	public void setnameofresource (String nameofresource) {
		this.nameofresource = nameofresource;
	}
	
	public String getnameofresource() {
		return nameofresource;
		
	}public void settypeofresource (String typeofresource) {
		this.typeofresource = typeofresource;
	}
	
	public String gettypeofresource() {
		return typeofresource;
	}
	
}
