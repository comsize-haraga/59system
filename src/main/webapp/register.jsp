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
		■タスク名<br>
			<select name="task_id">
			<option value=""></option>
			<option value="1">未着手サンプルタスク</option>
			<option value="2">着手サンプル</option>
			</select>
			<br>
			
		■カテゴリ情報<br>
			<select name="category_id">
			<option value=""></option>
			<option value="1">新商品A:開発プロジェクト</option>
			<option value="2">新商品B:改良プロジェクト</option>
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
			<select name="user_id">
			<option value=""></option>
			<option value="admin">山田</option>
			<option value="test1">テスト1</option>
			<option value="test2">テスト2</option>
			</select>
			<br>
		
		■ステータス情報<br>
			<select name="status_code">
			<option value=""></option>
			<option value="00">未着手</option>
			<option value="50">着手</option>
			<option value="99">完了</option>
			</select>
			<br>
		
		■メモ<br>
			<textarea cols="40"rows="2">
			</textarea>
			<br>
		
		<input type="submit" value="登録実行">
	</form>
	<form action="menu.jsp" method="POST">
		<input type="submit" value="メニュー画面へ">
	</form>
</body>
</html>