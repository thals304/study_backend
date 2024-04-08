<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 24.04.08 time 15:42-15:52
	today 소감문
	왜 한글이 ?로 나오는 거지? 내가 코드를 잘못 썼나? 그건 아닌 거 같은데 
	이클립에 문제가 있는건가 잘 모르겠다.
 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
	[문제 설명]<br><br>
	1. 2021 ~ 1900까지 년도 표기 <br>
	2. 1 ~ 12월까지 월에 표기 <br>
	3. 1 ~ 31일까지 일에 표기<br>
	</p>
	
	<select>
		<%
		   for(int i = 2021 ; i >= 1900; i-- ){
		%>
		   <option value=<%= i %>><%= i %></option>
		<%	   			   }
		%>
	</select>
	년
	<select>
		<%
			for(int i = 1; i <= 12; i++){
		%>
		    <option value=<%= i %>><%= i %></option>
		<% 		
			}
		%>
	</select>
	월
	<select>
		<%
			for(int i = 1; i <= 31; i++){
		%>
		    <option value=<%= i %>><%= i %></option>
		<% 		
				}
		%>
		</select>
		일
	
</body>
</html>