package pack;

import java.sql.ResultSet;
import java.sql.SQLException;

public class announ {
	
	private int announ_id;
	private int jobs_id;
	private int news_id;
	private String announcement;
	private String netid;
	private String linkjob;
	private String news;
	private String jobs;
	private String date;
	private String location;
	public String getAnnouncement() {
		return announcement;
	}
	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}
	public String getNetid() {
		return netid;
	}
	public void setNetid(String netid) {
		this.netid = netid;
	}
	public String getLinkjob() {
		return linkjob;
	}
	public void setLinkjob(String linkjob) {
		this.linkjob = linkjob;
	}
	public String getNews() {
		return news;
	}
	public void setNews(String news) {
		this.news = news;
	}
	
	public String getJobs() {
		return jobs;
	}
	public void setJobs(String jobs) {
		this.jobs = jobs;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getAnnoun_id() {
		return announ_id;
	}
	public void setAnnoun_id(int announ_id) {
		this.announ_id = announ_id;
	}
	public int getJobs_id() {
		return jobs_id;
	}
	public void setJobs_id(int jobs_id) {
		this.jobs_id = jobs_id;
	}
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}