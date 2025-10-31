package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.TaskBean;

public class RegisterDAO {
	public int register(TaskBean taskBean) throws ClassNotFoundException, SQLException{
		String sql = "INSERT INTO t_task (task_name, limit_date, memo, category_id, user_id, status_code) VALUES (?,?,?,?,?,?)";
		int result = 0;

		try (Connection con = ConnectionManager.getConnection();
				
				
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			if (taskBean.getLimit() != null && !taskBean.getLimit().isEmpty()) {
			java.sql.Date sqlDate = java.sql.Date.valueOf(taskBean.getLimit());
			
			pstmt.setString(1, taskBean.getTask_name());
			pstmt.setDate(2,sqlDate);
			pstmt.setString(3, taskBean.getMemo());
			pstmt.setInt(4, taskBean.getCategory_id());
			pstmt.setString(5, taskBean.getUser_id());
			pstmt.setString(6, taskBean.getStatus_code());
			result = pstmt.executeUpdate();
			return result;
			}
			return 0;
		}
	
	}
	
}
