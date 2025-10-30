<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除</title>
</head>
<body>
<h1>削除画面</h1>
<hr>
<form action="task-delete-servlet" method="POST">
<table border = "1">
タスクを削除します。よろしいですか？<br><br>
<tr><td>タスク名</td><td>session.getAttribute(task_name)</td></tr>

<tr><td>カテゴリ情報</td><td>category_name</td></tr>

<tr><td>期限</td><td>limit_date</td></tr>

<tr><td>担当者情報</td><td>user_name</td></tr>

<tr><td>ステータス情報</td><td>status_name</td></tr>

<tr><td>メモ</td><td>comment</td></tr>
</table>
<br>
<input type="submit" value="削除">
</form><br>

<form action="menu.jsp" method="POST">
<input type="submit" value="メニュー画面へ">
</form>
</body>
</html>