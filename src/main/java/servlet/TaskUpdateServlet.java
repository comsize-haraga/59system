package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DisplayDAO;
import model.dao.UpdateDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class TaskUpdateServlet
 */
@WebServlet("/task-update-servlet")
public class TaskUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	     int id = Integer.parseInt(request.getParameter("id"));
	     
	     TaskBean taskbean = new TaskBean();
	     taskbean.setTask_id(id);
	     
	    
	     DisplayDAO dao = new DisplayDAO();
	     List<TaskBean> tasklist = new ArrayList<>();
	     
	     
	     try {
			tasklist =  dao.SelectId(id);
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	     	request.setAttribute("tasklist", tasklist);
			
			RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int task_id = Integer.parseInt(request.getParameter("id"));
		String task_name =  request.getParameter("task_name");
		int category_id = Integer.parseInt(request.getParameter("category_id"));
		String limit = request.getParameter("limit_date");
		String user_id = request.getParameter("user_id");
		String status_code = request.getParameter("status_code");
		String memo = request.getParameter("memo");
		
	        
		TaskBean taskbean = new TaskBean();
		taskbean.setTask_id(task_id);
		taskbean.setTask_name(task_name);
		taskbean.setCategory_id(category_id);
		taskbean.setLimit(limit);
		taskbean.setUser_id(user_id);
		taskbean.setStatus_code(status_code);
		taskbean.setMemo(memo);
		
		
		UpdateDAO updatedao = new UpdateDAO();
		int cnt = 0;
		
		try {
			cnt =  updatedao.UpdateTask(taskbean);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		if(cnt == 1) {
			RequestDispatcher rd = request.getRequestDispatcher("update-success.jsp");
			rd.forward(request, response);
		
		}else {
			
			RequestDispatcher rd = request.getRequestDispatcher("update-failure.jsp");
			rd.forward(request, response);
			
		}
	}

}
