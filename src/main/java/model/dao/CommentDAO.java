package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CommentBean;

public class CommentDAO {

	// コメント投稿
	public int insertComment(CommentBean comment) throws SQLException, ClassNotFoundException {
		String sql =  "";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setInt(1, comment.getTask_id());
			pstmt.setString(2, comment.getUser_name());
			pstmt.setString(3, comment.getComment_text());

			return pstmt.executeUpdate();
		}
	}

	// コメント一覧取得（タスクID指定）
	public List<CommentBean> getCommentsByTaskId(int taskId) throws SQLException, ClassNotFoundException {
		List<CommentBean> list = new ArrayList<>();
		String sql = "";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setInt(1, taskId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				CommentBean c = new CommentBean();
				c.setComment_id(rs.getInt("comment_id"));
				c.setTask_id(rs.getInt("task_id"));
				c.setUser_name(rs.getString("user_name"));
				c.setComment_text(rs.getString("comment_text"));
				c.setCreated_at(rs.getTimestamp("created_at"));
				list.add(c);
			}
		}
		return list;
	}

}
