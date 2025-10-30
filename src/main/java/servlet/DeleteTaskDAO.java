package servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.dao.ConnectionManager;

public class DeleteTaskDAO {
	public int deleteTask(int task_id) 
			throws SQLException, ClassNotFoundException {

		String sql = "DELETE FROM t_task WHERE task_id = ?";
		int processingNumber = 0; //処理件数
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setInt(1, task_id);
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
}
