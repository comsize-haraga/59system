package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DeleteTaskDAO;

/**
 * Servlet implementation class TaskDeleteServlet
 */
@WebServlet("/task-delete-servlet")
public class TaskDeleteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		int taskId = Integer.parseInt(request.getParameter("task_id"));
		DeleteTaskDAO deletetaskdao = new DeleteTaskDAO();
		int processingNumber = 0; //処理件数
		
		
		try {
			// 削除処理
			processingNumber = deletetaskdao.deleteTask(Integer.parseInt(request.getParameter("task_id")));
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

}
