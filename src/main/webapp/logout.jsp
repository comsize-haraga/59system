<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ログアウト画面</h1>
お疲れ様でした！
<% 
session.invalidate();
%>


<h1>ログアウトしました。</h1>
<button onclick="location.href='./login.jsp'">ログイン画面へ</button>
</body>
</html>