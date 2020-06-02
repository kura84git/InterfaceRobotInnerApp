<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Remind" %>
<%
Remind specifiedRemindUpdate = (Remind)session.getAttribute("specifiedRemindUpdate");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Interface_Robot_InnerApp</title>
</head>
<body>
	<h2>こちらの内容で更新してもよろしいですか？？</h2><br>
	<p>リマインド：<%= specifiedRemindUpdate.getRemind() %></p>
	<p>カテゴリ：<%= specifiedRemindUpdate.getCategory() %></p>
	<p>
		<a href="/Interface_Robot_InnerApp/ReminderUpdate?action=done">更新する</a>
		<a href="/Interface_Robot_InnerApp/ReminderUpdate">戻る</a>
	</p>
</body>
</html>