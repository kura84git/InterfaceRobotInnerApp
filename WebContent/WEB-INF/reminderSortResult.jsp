<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Remind" %>
<%@ page import="java.util.List" %>
<%
List<Remind> remindSortList = (List<Remind>)request.getAttribute("remindSortList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Interface_Robot_InnerApp</title>
</head>
<body>
	<% for(Remind remind : remindSortList) { %>
		<p><%= remind.getRemind() %></p>
	<% } %>

	<p><a href="/Interface_Robot_InnerApp/ReminderSort">カテゴリソート検索へ戻る</a></p>
	<p><a href="/Interface_Robot_InnerApp/Reminder">リマインダーアプリトップへ戻る</a></p>

</body>
</html>