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
	<%
		if (loginUser != null) {
	%>
	<p>ログイン成功</p>
	<p>ようこそ<%= loginUser.getId() %>さん</p>
	<p>
		<a href="/Interface_Robot_InnerApp/Main">メインページへ</a>
	</p>
	<% } else { %>
	<p>ログイン失敗</p>
	<p>
		<a href="/Interface_Robot_InnerApp/index.jsp">トップへ戻る</a>
	</p>
	<% } %>

	<p>
		<a href="/Interface_Robot_InnerApp/Logout">ログアウト</a>
	</p>

</body>
</html>