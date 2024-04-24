<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<%-- view(jsp)에서 session객체에 접근하는 방법 : ${sessionScope.속성명} --%>
	<%-- view(jsp)에서 request객체에 접근하는 방법 : ${requestScope.속성명} or ${속성명} --%>
	<h3>${sessionScope.id }님의 마이페이지 (${sessionScope.role })</h3> <%-- sessionScope. 생략 불가능 --%>
	<h5> 이름 : ${requestScope.name } </h5> <%-- requestScope. 생략 가능 --%> 
	<h5> 연락처 : ${hp }</h5>
	<h5> 주소 : ${address }</h5>
	
</body>
</html>