<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Remind" %>
<%
Remind remindDelete = (Remind)session.getAttribute("remindDelete");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Interface_Robot_InnerApp</title>
</head>
<body>
	<h2>こちらの内容で削除してもよろしいですか？？</h2><br>
	<p>リマインド：<%= remindDelete.getRemind() %></p>
	<p>カテゴリ：<%= remindDelete.getCategory() %></p>
	<p>
		<a href="/Interface_Robot_InnerApp/ReminderDelete">削除する</a>
		<a href="/Interface_Robot_InnerApp/Reminder">戻る</a>
	</p>
</body>
</html>