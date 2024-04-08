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
		
		1. 2021 ~ 1900까지 년도에 표기 <br>
		2. 1 ~ 12까지 월에 표기 <br>
		3. 1 ~ 31까지 일에 표기 <br>
	</p>

	<select>
		<% 
			for (int i = 2021; i >= 1900; i--) {
		%>
				<option value=<%=i %>><%=i %></option>
		<% 			
			}
		%>
	</select>년
	<select>
		<% 
			for (int i = 1; i <= 12; i++) {
		%>
				<option value=<%=i %>><%=i %></option>
		<% 			
			}
		%>
	</select>월
	<select>
		<% 
		for (int i = 1; i <= 31; i++) {
		%>
				<option value=<%=i %>><%=i %></option>
		<% 			
			}
		%>
	</select>일
	
	
</body>
</html>