<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Remind" %>
<%@ page import="java.util.List" %>
<%
List<Remind> remindList = (List<Remind>)session.getAttribute("remindList");

String errorMsg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Interface_Robot_InnerApp</title>
</head>
<body>
	<form action="/Interface_Robot_InnerApp/Reminder" method="post">
		<p>リマインド内容：<input type="text" name="remind"></p>
		<p>カテゴリ：<input type="text" name="category"></p>
		<p><input type="submit" value="リマインド内容を保存する！"></p>
	</form>

	<input type="button" onClick="location.href='/Interface_Robot_InnerApp/ReminderSort'" value="カテゴリソート検索">

	<% if(errorMsg != null){ %>
		<p><%= errorMsg %></p>
	<% } %>

	<% for(Remind remind : remindList) { %>
		<p><%= remind.getRemind() %> <br> カテゴリ：<%= remind.getCategory() %></p>
		<p>
			<form action="/Interface_Robot_InnerApp/ReminderUpdate" method="post">
				<input type="hidden" name="remind" value="<%= remind.getRemind() %>">
				<input type="hidden" name="category" value="<%= remind.getCategory() %>">
				<input type="submit" value="更新">
			</form>
			<form action="/Interface_Robot_InnerApp/ReminderDelete" method="post">
				<input type="hidden" name="remind" value="<%= remind.getRemind() %>">
				<input type="hidden" name="category" value="<%= remind.getCategory() %>">
				<input type="submit" value="削除"><br><br>
			</form>
		</p>
	<% } %>

	<p><a href="/Interface_Robot_InnerApp/Main">トップへ戻る</a></p>
</body>
</html>