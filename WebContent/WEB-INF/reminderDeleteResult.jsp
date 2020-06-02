<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% boolean deleteResult = (boolean)request.getAttribute("deleteResult"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Interface_Robot_InnerApp</title>
</head>
<body>
	<% if(deleteResult) { %>
		<p>削除が完了しました！！</p>
	<% } else { %>
		<p>削除に失敗しました・・・</p>
	<% } %>
	<p><a href="/Interface_Robot_InnerApp/Reminder">リマインダーアプリトップへ戻る</a></p>
</body>
</html>