<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Interface_Robot_InnerApp</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Interface_Robot_InnerApp/css/calenderStyle.css">
<body>
	<h1 class="center">万年カレンダー</h1><br>
	<h1 class="center">出力したい年月を入力してください。</h1>
	<form method='post' action='/Interface_Robot_InnerApp/Calender'>
	    <p class="center">年：<input type='text' name='year'></p>
	    <p class="center">月：<input type='text' name='month'></p>
	    <p class="center"><input type='submit' name='bttn' value='ボタン' ></p>
	</form>
	<p class="center"><a href="/Interface_Robot_InnerApp/Main">トップへ戻る</a></p>
</body>
</html>


