package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.RegisterDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class TaskAddServlet
 */
@WebServlet("/register-servlet")
public class RegisterServlet extends HttpServlet {



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		RegisterDAO rgd = new RegisterDAO();
		TaskBean taskBean = new TaskBean();
		
		//入力した値を変数に入れる
		String taskName = request.getParameter("task_name");
		int categoryId = Integer.parseInt(request.getParameter("category_id"));
		
		String strLimit = request.getParameter("limit");
		SimpleDateFormat sdFormat = new SimpleDateFormat(strLimit );
		String userId = request.getParameter("user_id");
		int statusCode = Integer.parseInt(request.getParameter("status_code"));
		String memo = request.getParameter("memo");
		try {
			Date limit = sdFormat.parse(strLimit);
			taskBean.setTask_name(taskName);
			taskBean.setCategory_id(categoryId);
			taskBean.setLimet_date(limit);
			taskBean.setUser_id(userId);
			taskBean.setStatus_code(statusCode);
			taskBean.setMemo(memo);
			try {
				int result = rgd.register(taskBean);
			
			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	
		
		//taskbeanに値をセットする
		
				
			
				
	}

}
