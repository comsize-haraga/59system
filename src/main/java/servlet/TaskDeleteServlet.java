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

import model.dao.DeleteTaskDAO;
import model.dao.DisplayDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class TaskDeleteServlet
 */
@WebServlet("/task-delete-servlet")
public class TaskDeleteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		//int taskId = Integer.parseInt(request.getParameter("taskId"));
		DeleteTaskDAO deletetaskdao = new DeleteTaskDAO();
		int processingNumber = 0; //処理件数
		
		try {
			// 削除処理
			processingNumber = deletetaskdao.deleteTask(Integer.parseInt(request.getParameter("taskId")));
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 処理件数をリクエストスコープに設定
		request.setAttribute("processingNumber", processingNumber);
		// 削除結果画面に遷移
		if (processingNumber == 1) {
			RequestDispatcher rd = request.getRequestDispatcher("delete-success.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("delete-failure.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
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
			
			RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
			rd.forward(request, response);
	}

}
