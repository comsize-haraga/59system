<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.List,model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table border=1 >
	<tr>
	<td align="center"> タスクID </td>
	<td align="center"> タスク名 </td>
	<td align="center"> カテゴリID </td>
	<td align="center"> 期限 </td>
	<td align="center"> ユーザー名 </td>
	<td align="center"> ステータスコード </td>
	<td align="center"> メモ </td>
	<td align="center"> 登録日時 </td>
	<td align="center"> 更新日時 </td>
	</tr>
	
	<% List<TaskBean> displaylist = (List)request.getAttribute("displaylist");%>
	
	<%
	for(TaskBean bean : displaylist){ %>
		
		<tr>
		<td align="center"> <%= bean.getTask_id() %> </td>
		<td align="center"> <%= bean.getTask_name() %></td>
		<td align="center"> <%= bean.getCategory_id() %> </td>
		<td align="center"> <%= bean.getLimit_date() %> </td>
		<td align="center"> <%= bean.getUser_id() %> </td>
		<td align="center"> <%= bean.getStatus_code() %> </td>
		<td align="center"> <%= bean.getMemo() %> </td>
		<td align="center"> <%= bean.getCreate_datetime() %> </td>
		<td align="center"> <%= bean.getUpdate_datetime() %> </td>		
		 </tr>
		
	
	<% } %>
	
	</table>
	
	<br>
	<form action = "menu.jsp" method="post">
	
	<input type="submit" value="メニュー画面へ">
	
	</form>
</body>
</html>