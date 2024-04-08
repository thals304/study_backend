<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습예시</title>
</head>
<body>
		
	<p>
		[ 문제설명 ]<br><br>
		
		1.  1월 부터 12월까지 셀렉트 태그를 만든다.<br>
		2. 
			&emsp;1, 3, 5, 7, 8, 10, 12 월은 '1일 ~ 31일' ,<br> 
			&emsp;&emsp;2월은 '1일 ~ 28일' , <br>
			&emsp;&emsp;4, 6, 9, 11월은 '1일 ~ 30일'을 셀렉트 태그에 표기한다.<br>
	    3. 마지막일자에 selected 옵션을 선택한다.
	</p>

	<%
		
		int day = 0;

		for (int i = 1; i <= 12; i++){
			
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) day = 31;
			else if (i == 2) 														  day = 28;
			else if (i == 4 || i == 6 || i == 9 || i == 11) 						  day = 30; 
	%>
			<%=i %>월 : 
			<select>
				<% 
					for (int j = 1; j <= day; j++) {
				%>
						<option value=<%=j %> <% if(j == day) { %> selected <%} %>><%=j %></option>
				<% 			
					}
				%>
			</select>일
			<br>
	<% 		
		}
		
	%>
	
</body>
</html>