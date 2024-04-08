<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 24.04.08 time 16:17-16:24
	today 소감문
	오래 걸릴 줄 알았는데 구조와 for문을 적절히 잘 사용하니 쉽게 만들 수 있었던 것 같다.
 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 	<p>
 	[문제 설명]<br><br>
 	구구단을 2~9단까지 출력해보시오.
 	</p>
 	
 	<%
 		for(int i = 2; i <= 9; i++){
 	%>
 		<table border="1">
 			<tr>
 				<th colspan="2"><%= i %>단</th>
 			</tr>
 			<%
 				for (int j = 1; j <= 9; j++){
 			%>
 			<tr>
 				<td><%=i %> * <%=j %></td>
 				<td><%= i*j %></td>
 			</tr>
 			<% 
 				}
 			%>
 		</table>
 		<hr/>
 	<% 		
 		}
 	%>
</body>
</html>