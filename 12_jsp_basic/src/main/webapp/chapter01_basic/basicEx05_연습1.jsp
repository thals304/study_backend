<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 24.04.08 time 14:28-14:31
     today 소감문
     table을 사용하고 tr을 사용해야 된다는 것을 알고 있었는데
     1행 1열만 쓰더라도 td를 써줘야 한다는 점을 까먹고 있었다.
-->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<table border="1">
 	<%
 	    for (int i = 1; i <= 10; i++){
 	%>
 	<tr>
 	    <td><%= i %>번</td>
 	</tr>
 	<% 
 	    }
 	%>
 	</table>
</body>
</html>