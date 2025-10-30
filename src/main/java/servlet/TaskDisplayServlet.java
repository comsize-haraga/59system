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
import javax.servlet.http.HttpSession;

import model.dao.DisplayDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class TaskDisplay
 */
@WebServlet("/task-display-servlet")
public class TaskDisplayServlet extends HttpServlet {
	
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		DisplayDAO displaydao = new DisplayDAO();
		List<TaskBean> displaylist = new ArrayList<>();
		
		try {
			displaylist =  displaydao.display();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} 
		TaskBean bean = new TaskBean();
		int task_id = bean.getTask_id();
		
		HttpSession session = request.getSession();
		session.setAttribute("task_id", task_id);
		
		
	    request.setAttribute("displaylist", displaylist);
		
		RequestDispatcher rd = request.getRequestDispatcher("Task_display.jsp");
		rd.forward(request, response);
	}

}
