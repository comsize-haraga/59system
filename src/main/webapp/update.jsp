<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク編集</title>
</head>
<body>
<h1>タスク編集画面</h1>
<hr>
<form action="task-update-servlet" method="POST">
<table border = "1">
<tr><td>タスク名</td><td><input type="text" name="task_name" style="width:300px;"></td></tr>

<tr><td>カテゴリ情報</td><td><select name="category_name"></select></td></tr>

<tr><td>期限</td><td><select name="limit_date"></select></td></tr>

<tr><td>担当者情報</td><td><input type="text" name="user_name"></td></tr>

<tr><td>ステータス情報</td><td><input type="text" name="status_name" style="width:300px;"></td></tr>

<tr><td>メモ</td><td><input type="text" name="comment" style="width:300px;"></td></tr>
</table>
<br>
<input type="submit" value="変更する">
</form><br>

<form action="menu.jsp" method="POST">
<input type="submit" value="メニュー画面へ">
</form>

</body>
</html>