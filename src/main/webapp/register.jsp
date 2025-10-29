<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録</title>
</head>
<body>
	<h1>タスク登録画面</h1>
	<hr>
		<form action="task-add-servlet" method="POST">
		<table border="1">
			<tr>
				<th>タスク名</th>
				<td><select name="task_name">
				</select></td>
			</tr>	
		<tr>
				<th>価格</th>
				<td><input type="number" name="price">円</td>
			</tr>
		</table>
		
</body>
</html>