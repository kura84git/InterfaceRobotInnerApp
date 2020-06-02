<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<%
	User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Interface_Robot_InnerApp</title>
</head>
<body>
	<p>
		<%= loginUser.getId() %>さん、ログイン中！
		<a href="/Interface_Robot_InnerApp/Logout">ログアウト</a>
	</p>
	<h1>↓好きなアプリを起動させてね↓</h1>
	<input type="button" onClick="location.href='/Interface_Robot_InnerApp/Reminder'" value="リマインダー">
	<input type="button" onClick="location.href='/Interface_Robot_InnerApp/Calender'" value="万年カレンダー">
	<input type="button"  onClick="location.href='/Interface_Robot_InnerApp/BlockBreaking'" value="ブロック崩し">
</body>
</html>