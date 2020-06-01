<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Remind" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %>
<%
Set<Remind> categoryList = (Set<Remind>)request.getAttribute("categoryList");

List<Remind> remindSortList = (List<Remind>)request.getAttribute("remindSortList");

String errorMsg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Interface_Robot_InnerApp</title>
</head>
<body>
	<form action="/Interface_Robot_InnerApp/ReminderSort" method="post">
		<p>ソートしたいカテゴリを入力してください：<input type="text" name="category"></p>
		<p><input type="submit" value="このカテゴリでソートする！"></p>
	</form>

	<% if(errorMsg != null){ %>
		<p><%= errorMsg %></p>
	<% } %>

	<p>カテゴリ一覧</p>
	<% for(Remind category : categoryList) { %>
		<p><%= category.getCategory() %></p>
	<% } %>


	<p><a href="/Interface_Robot_InnerApp/Reminder">リマインダーアプリトップへ戻る</a></p>
</body>
</html>