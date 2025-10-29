package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.UserBean;

public class UserDAO {
	
	public List<UserBean> selectAll() throws SQLException, ClassNotFoundException {

		List<UserBean> UserList = new ArrayList<UserBean>();

		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT user_id, password, user_name FROM m_user")) {

			// プレースホルダへの値の設定

			// SQLステートメントの実行

			while (res.next()) {
				String user_id = res.getString("user_id");
				String password = res.getString("password");
				String user_name = res.getString("user_name");

				UserBean user = new UserBean();
				
				user.setId(user_id);
				user.setPw(password);
				user.setName(user_name);

				UserList.add(user);
			}

			return UserList;

		}
		}
	
	

}
