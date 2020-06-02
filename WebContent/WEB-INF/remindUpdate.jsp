<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Remind" %>
<%
Remind remindUpdate = (Remind)session.getAttribute("remindUpdate");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Interface_Robot_InnerApp</title>
</head>
<body>
	<h1>更新</h1>
	<h2>更新内容を入力してください</h2>
	<form action="/Interface_Robot_InnerApp/ReminderUpdate?action=register" method="post">
		<p>リマインド：<input type="text" name="specifiedRemind"></p>
		<p>カテゴリ：<input type="text" name="specifiedCategory"></p>
	</form>

	<p>現在のリマインド内容</p>
	<p>リマインド：<%= remindUpdate.getRemind() %></p>
	<p>カテゴリ：<%= remindUpdate.getCategory() %></p>

	<p><a href="/Interface_Robot_InnerApp/Reminder">リマインダーアプリトップへ戻る</a></p>
</body>
</html>