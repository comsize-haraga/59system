<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.List,model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>タスク一覧</h1>
	<hr>
	
		<table border=1 >
	<tr>
	<td align="center"> タスク名 </td>
	<td align="center"> カテゴリ情報 </td>
	<td align="center"> 期限 </td>
	<td align="center"> 担当者情報 </td>
	<td align="center"> ステータス情報 </td>
	<td align="center"> メモ </td>
	</tr>
	
	<% List<TaskBean> displaylist = (List)request.getAttribute("displaylist");%>
	
	<%
	for(TaskBean bean : displaylist){ %>
		
		<tr>
		<td align="center"> <%= bean.getTask_name() %> </td>
		<td align="center"> <%= bean.getCategory_name() %></td>
		<td align="center"> <%= bean.getLimet_date() %> </td>
		<td align="center"> <%= bean.getUser_name() %> </td>
		<td align="center"> <%= bean.getStatus_name() %> </td>
		<td align="center"> <%= bean.getMemo() %> </td>
		
	<td><form action = "task-update-servlet" method="get">
	<%// 主キー受け取り %>
	<input type ="hidden" name = id value = <%=bean.getTask_id() %>>
	<input type="submit" value="編集">
	
	</form></td>
	
	<td><form action = "task-delete-servlet" method="post">
	<input type ="hidden" name = id value = <%=bean.getTask_id() %>>
	<input type="submit" value="削除">
	
	</form></td>
	</tr>
	<% } %>
	
	</table>
	
	
	<form action = "menu.jsp" method="post">
	
	<input type="submit" value="メニュー画面へ">
	
	</form>
</body>
</html>