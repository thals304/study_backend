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
		
		1.  랜덤객체를 생성하여 1부터 12까지 선택한다.<br>
		2. <br>
			1, 3, 5, 7, 8, 10, 12 월은 '1일 ~ 31일' ,<br> 
			2월은 '1일 ~ 28일' , <br>
			4, 6, 9, 11월은 '1일 ~ 30일'을 셀렉트 태그에 표기하시오.<br> 
	</p>

	<%
	
		Random ran = new Random();
		
		int month = ran.nextInt(12) + 1;
		int day = 0;
		
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) day = 31;
		else if (month == 2) 																				  day = 28;
		else if (month == 4 || month == 6 || month == 9 || month == 11) 									  day = 30; 
	%>
	<%=month %>월 : 
	<select>
		<% 
			for (int i = 1; i <= day; i++) {
		%>
				<option value=<%=i %>><%=i %></option>
		<% 			
			}
		%>
	</select>일
	
</body>
</html>