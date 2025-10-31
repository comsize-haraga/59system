package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.UserBean;

public class UserDAO {

	public UserBean select(String user_id, String password)
			throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM m_user WHERE user_id = ? AND password = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, user_id);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				UserBean user = new UserBean();
				// DBのカラム名に合わせて修正（例）
				user.setUser_id(rs.getString("user_id"));
				user.setPassword(rs.getString("password"));
				user.setUser_name(rs.getString("user_name"));
				return user;
				
			} else {
				return null;
			}
		}
	}
}
