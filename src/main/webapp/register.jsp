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
		■タスク名
			<input type="text"width="100"name="task">
			<br>
			
		■カテゴリ情報<br>
			<select name="category_name">
			<option value="task_name">新商品A:開発プロジェクト</option>
			<option value="task_name">新商品B:改良プロジェクト</option>
			</select>
			<br>
		
		■期限<br>
			<input type="date" name="limit" id="limitDate">
			<script>
			const today = new Date();
			//昨日より前を選べないようにする
			const yyyy = today.getFullYear();
			const mm = String(today.getMonth() + 1).padStart(2, '0');
			const dd = String(today.getDate()).padStart(2, '0');
			const minDate = yyyy + '-' + mm + '-' + dd;
					document.getElementById('limitDate').setAttribute('min', minDate);
			</script>
			<br>
		
		■担当者情報<br>
			<select name="user_name">
			</select>
			<br>
		
		■ステータス情報<br>
			<select name="status_name">
			<option value="status_name">未着手</option>
			<option value="status_name">着手</option>
			<option value="status_name">完了</option>
			</select>
			<br>
		
		■メモ<br>
			<textarea cols="40"rows="2">
			</textarea>
			<br>
		
		<input type="submit" value="登録実行">
	</form>
	<form action="task_display.jsp" method="POST">
		<input type="submit" value="一覧画面へ">
	</form>
</body>
</html>