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
		
		구구단을 2 ~ 9 단까지 출력해보시오.
		
	</p>
	
	<%
		for (int i = 2; i < 10 ; i++) {
	%>
			<table border="1">
				<tr>
					<th colspan="2"><%=i %>단</th>
				</tr>		
	<% 
			for (int j = 1; j < 10; j++) {
	%>
				<tr align="center">
					<td><%=i %> * <%=j %></td>
					<td><%=i * j %></td>
				</tr>
	<% 				
			}
	%>
			</table>
			<hr>
	<%
		}
	%>
	
</body>
</html>