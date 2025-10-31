<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク編集</title>
</head>
<body>
	<h1>タスク編集画面</h1>
	<hr>
		<%
		List<TaskBean> tasklist = (List) request.getAttribute("tasklist");
		%>

	<form action="task-update-servlet" method="POST">
		<table border="1">
			<%
			for (TaskBean bean : tasklist) {
			%>
			<tr>
				<td>タスク名</td>
				<td><input type="text" name="task_name" style="width: 300px"
					value=<%=bean.getTask_name()%>></td>
			</tr>
			<tr>
				<td>カテゴリ情報</td>
				<td><select name="category_name">
					<option value=<%=bean.getCategory_id()%>>
						<%=bean.getCategory_name()%>
					</option>
					<option value=1>新商品A：開発プロジェクト</option>
					<option value=2>既存商品B：改良プロジェクト</option>
				</select></td>
			</tr>
			<tr>
				<td>期限</td>
				<td><input type="date" name="limit_date"
					value=<%=bean.getLimet_date()%>></td>
			</tr>
			<tr>
				<td>担当者情報</td>
				<td><input type="text" name="user_name"
					value=<%=bean.getUser_id()%>></td>
			</tr>
			<tr>
				<td>ステータス情報</td>
				<td><select name="status_name">
					<option value=<%=bean.getStatus_code()%>><%=bean.getStatus_name()%></option>
					<option value=00>未着手</option>
					<option value=50>着手</option>
					<option value=99>完了</option>
				</select></td>
			</tr>
			<tr>
				<td>メモ</td>
				<td><input type="text" name="comment" style="width: 300px"
					value=<%=bean.getMemo()%>></td>
			</tr>
			<%
			}
			%>
		</table>
		<br> <input type="submit" value="変更する">
	</form>
	<br>

	<form action="menu.jsp" method="POST">
		<input type="submit" value="メニュー画面へ">
	</form>
</body>
</html>