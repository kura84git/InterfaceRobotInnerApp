<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Interface_Robot_InnerApp</title>
</head>
<body>
	<h1>ログイン</h1>
	<form action="/Interface_Robot_InnerApp/Login" method="post">
		<p>ユーザーID：<input type="text" name="id"></p>
		<p>パスワード：<input type="password" name="pass"></p>
		<p><input type="submit" value="ログイン！"></p>
	</form>
	<p><a href="/Interface_Robot_InnerApp/Register">新規登録はこちら</a></p>
</body>
</html>