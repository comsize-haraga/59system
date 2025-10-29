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
			
			ResultSet res = stmt.executeQuery("select * from t_task");
			
		while(res.next()) {
			
			//検索結果受け取り
			int task_id = res.getInt("task_id");
			String task_name = res.getString("task_name");
			int category_id = res.getInt("category_id");
			String user_id = res.getString("user_id");
			String status_code = res.getString("status_code");
			String memo = res.getString("memo");
			
			
			
			//TaskBeanにデータ受け渡し
			TaskBean taskbean = new TaskBean();
			
			taskbean.setTask_id(task_id);
			taskbean.setTask_name(task_name);
			taskbean.setCategory_id(category_id);
			taskbean.setLimit_date( res.getDate("limit_date"));
			taskbean.setUser_id(user_id);
			taskbean.setStatus_code(status_code);
			taskbean.setMemo(memo);
			taskbean.setCreate_datetime(res.getTimestamp("create_datetime"));
			taskbean.setUpdate_datetime(res.getTimestamp("update_datetime"));
			
			
			tasklist.add(taskbean);
		}
		
		return tasklist;
		
	}
	}
}
