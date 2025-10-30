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
		
		String task_name =  request.getParameter("task_name");
		String category_name = request.getParameter("category_name");
		//Date limit = request.getParameter("limit_date");
		String user_name = request.getParameter("user_name");
		String status_name = request.getParameter("status_name");
		
		
	}

}
