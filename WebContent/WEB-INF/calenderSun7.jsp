<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String ybox = (String)request.getAttribute("ybox"); //第一引数
String mbox = (String)request.getAttribute("mbox"); //第二引数
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"  href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css"><link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet"><link rel="stylesheet" type="text/css" href="/Interface_Robot_InnerApp/css/calenderStyle.css">
<title>Interface_Robot_InnerApp</title>
</head>
<body>
<h1 class="center">カレンダー表示</h1>
<div id="container"><h1 class="center"><%= ybox %>年<%= mbox %>月のカレンダー</h1>

<%
/* 国民の祝日
元日 1/1 成人の日 1月の第2月曜日
建国記念日 2/11 天皇誕生日 2/23
春分の日 西暦年 % 4 == 0 or 1 -> 3/20 西暦年 % 4 == 2 or 3 -> 3/21
昭和の日 4/29
憲法記念日 5/3 みどりの日 5/4 こどもの日 5/5
海の日 7月の第3月曜日
山の日 8/11
敬老の日 9月の第3月曜日 秋分の日 西暦年 % 4 == 0 -> 9/22 西暦年 % 4 == 1 or 2 or 3 -> 9/23
スポーツの日 10月の第2月曜日
文化の日 11/3 勤労感謝の日 11/23
振替休日 国民の祝日が日曜日にあたるとき、その後の最初の平日に該当する
*/
%>

<%-- 7月のときのカレンダー表示 海の日 7月の第3月曜日 --%>
<table border='1' align='center'>
	<tr>
		<th><div class="sun">日</div></th>
		<th>月</th>
		<th>火</th>
		<th>水</th>
		<th>木</th>
		<th>金</th>
		<th><div class="sat">土</div></th>
	</tr>
	<tr>
		<td><div class="sun">1</div></td>
		<td>2</td>
		<td>3</td>
		<td>4</td>
		<td>5</td>
		<td>6</td>
		<td><div class="sat">7</div></td>
	</tr>
	<tr>
		<td><div class="sun">8</div></td>
		<td>9</td>
		<td>10</td>
		<td>11</td>
		<td>12</td>
		<td>13</td>
		<td><div class="sat">14</div></td>
	</tr>
	<tr>
		<td><div class="sun">15</div></td>
		<td><div class="sun">16</div></td>
		<td>17</td>
		<td>18</td>
		<td>19</td>
		<td>20</td>
		<td><div class="sat">21</div></td>
	</tr>
	<tr>
		<td><div class="sun">22</div></td>
		<td>23</td>
		<td>24</td>
		<td>25</td>
		<td>26</td>
		<td>27</td>
		<td><div class="sat">28</div></td>
	</tr>
	<tr>
		<td><div class="sun">29</div></td>
		<td>30</td>
		<td>31</td>
		<td>　</td>
		<td>　</td>
		<td>　</td>
		<td><div class="sat">　</div></td>
	</tr>
</table></div><!-- end container -->

<p class="center"><a href="/Interface_Robot_InnerApp/Calender">カレンダーアプリトップへ戻る</a></p><p class="center"><a href="/Interface_Robot_InnerApp/Main">トップへ戻る</a></p>
</body>
</html>


