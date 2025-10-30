<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除</title>
</head>
<body>
<h1>削除画面</h1>
<hr>
<%
List<TaskBean> tasklist = (List<TaskBean>) request.getAttribute("tasklist");
for (TaskBean task : tasklist) {
%>
<% 
session.setAttribute("tasklist", tasklist);
%>
<form action="task-delete-servlet" method="POST">
<table border = "1">
タスクを削除します。よろしいですか？<br><br>
<input type="hidden" name="taskId" value="<%= task.getTask_id() %>">

<tr><td>タスク名</td><td><%= task.getTask_name() %></td></tr>

<tr><td>カテゴリ情報</td><td><%= task.getCategory_name() %></td></tr>

<tr><td>期限</td><td><%= task.getLimet_date() %></td></tr>

<tr><td>担当者情報</td><td><%= task.getUser_name() %></td></tr>

<tr><td>ステータス情報</td><td><%= task.getStatus_name() %></td></tr>

<tr><td>メモ</td><td><%= task.getMemo() %></td></tr>
</table>
<br>

<%} %>

<input type="submit" value="削除">
</form><br>

<form action="menu.jsp" method="POST">
<input type="submit" value="メニュー画面へ">
</form>
</body>
</html>