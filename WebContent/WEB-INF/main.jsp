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
<link rel="stylesheet" type="text/css" href="/Interface_Robot_InnerApp/css/style.css">
</head>
<body>
	<div class="wrapper">
		<div class="head">
			<p>
				<%= loginUser.getId() %>さん、ログイン中！
				<a href="/Interface_Robot_InnerApp/Logout">ログアウト</a>
			</p>
		</div>
		<div class="main">
			<div class="left-contents">
				<h1>↓好きなアプリを起動させてね↓</h1>
				<input type="button" onClick="location.href='/Interface_Robot_InnerApp/Reminder'" value="リマインダー">
				<input type="button" onClick="location.href='/Interface_Robot_InnerApp/Calender'" value="万年カレンダー">
				<input type="button"  onClick="location.href='/Interface_Robot_InnerApp/BlockBreaking'" value="ブロック崩し">
			</div>
			<div class="right-contents">
				<p>Command</p>
			</div>
		</div>
	</div>
</body>
</html>