package model.entity;

import java.util.Date;

public class CommentBean {

	private int comment_id; // コメントID
	private int task_id; // コメント対象のタスクID
	private String user_id; // コメント投稿者のユーザーID
	private String comment_text; // コメント内容
	private Date created_at; // 投稿日時
	private String user_name; // 投稿者名（表示用）

	// comment_id
	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	// task_id
	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	// user_id
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	// comment_text
	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}

	// created_at
	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	// user_name
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
}
