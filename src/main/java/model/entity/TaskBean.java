package model.entity;

import java.util.Date;

public class TaskBean {
	
	private String task_name;
	private String category_name;
	private Date limet_date;
	private String user_name;
	private String status_name;
	private String memo;
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public Date getLimet_date() {
		return limet_date;
	}
	public void setLimet_date(Date limet_date) {
		this.limet_date = limet_date;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getStatus_name() {
		return status_name;
	}
	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
	
}
