package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.TaskBean;

public class UpdateDAO {
	public int UpdateTask(TaskBean bean) throws ClassNotFoundException, SQLException {
		
		int cnt = 0;
		
		String sql = "UPDATE t_task SET task_name   = ?, category_id = ?, "
				+ "limit_date  = ?,user_id  = ?,status_code = ?,"
				+ "memo = ? ,WHERE task_id = ?";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setString(1,bean.getTask_name());
			pstmt.setInt(2,bean.getCategory_id());
			pstmt.setDate(3,(Date) bean.getLimet_date());
			pstmt.setString(4,bean.getUser_id());
			pstmt.setString(5,bean.getStatus_code());
			pstmt.setString(6,bean.getMemo());
			pstmt.setInt(7,bean.getTask_id());
			
			cnt = pstmt.executeUpdate();
		}
		return cnt;
		
	}
}
