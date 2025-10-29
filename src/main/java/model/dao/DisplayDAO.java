package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskBean;

public class DisplayDAO {
	
	public List<TaskBean> display() throws SQLException, ClassNotFoundException{
		
		List<TaskBean> tasklist = new ArrayList<>();
		
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement()){
			
			ResultSet res = stmt.executeQuery("SELECT \n"
					+ "t1.task_name,t3.category_name,t1.limit_date,"
					+ "t4.user_name,t2.status_name,t1.memo\n"
					+ "FROM t_task t1\n"
					+ "INNER JOIN m_status t2 ON\n"
					+ "t1.status_code = t2.status_code\n"
					+ "INNER JOIN m_category t3 ON\n"
					+ "t1.category_id = t3.category_id\n"
					+ "INNER JOIN m_user t4 ON\n"
					+ "t1.user_id = t4.user_id;");
			
		while(res.next()) {
			
			//検索結果受け取り/TaskBeanにデータ受け渡し
			TaskBean taskbean = new TaskBean();
			
			taskbean.setTask_name(res.getString("task_name"));
			taskbean.setCategory_name(res.getString("category_name"));
			taskbean.setLimet_date(res.getDate("limit_date"));
			taskbean.setUser_name(res.getString("user_name"));
			taskbean.setStatus_name(res.getString("status_name"));
			taskbean.setMemo(res.getString("memo"));
			
			
			tasklist.add(taskbean);
		}
		
		return tasklist;
		
	}
	}
}
