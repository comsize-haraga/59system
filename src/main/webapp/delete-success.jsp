<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除完了</title>
</head>
<body>
<h1>削除完了</h1>
<hr>
<table border = "1">
タスクを削除しました。<br><br>
<tr><td>タスク名</td><td>task_name</td></tr>

<tr><td>カテゴリ情報</td><td>category_name</td></tr>

<tr><td>期限</td><td>limit_date</td></tr>

<tr><td>担当者情報</td><td>user_name</td></tr>

<tr><td>ステータス情報</td><td>status_name</td></tr>

<tr><td>メモ</td><td>comment</td></tr>
</table>
<br>

<form action="menu.jsp" method="POST">
<input type="submit" value="メニュー画面へ">
</form>
</body>
</html>