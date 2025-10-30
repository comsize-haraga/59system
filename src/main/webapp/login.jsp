<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
    <h1>ログイン画面</h1>
    <hr>
    <h3>ユーザーIDとパスワードを入力してください</h3>

    <form action="Loginservlet" method="POST">
        ユーザID: <input type="text" name="user_id" size="24" required><br>
        パスワード: <input type="password" name="password" size="24" required><br><br>
        <input type="submit" value="ログイン">
        <input type="reset" value="取消">
    </form>
</body>
</html>
