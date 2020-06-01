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
	<% } %>

	<p><a href="/Interface_Robot_InnerApp/Main">トップへ戻る</a></p>
</body>
</html>