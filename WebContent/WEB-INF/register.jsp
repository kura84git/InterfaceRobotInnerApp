<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Interface_Robot_InnerApp</title>
</head>
<body>
	<h2>新規会員登録</h2>
	<form action="/Interface_Robot_InnerApp/Register" method="post" name="form02" onSubmit="return check()">
		<p>ユーザーID：<input type="text" name="id"></p>
		<p>名前：<input type="text" name="name"></p>
		<p>パスワード：<input type="password" name="pass"></p>
		<p>メールアドレス：<input type="text" name="mail"></p>
		<p>ロボット名：<input type="text" name="botName"></p>
		<p><input type="submit" value="確認"></p>
	</form>
</body>
</html>