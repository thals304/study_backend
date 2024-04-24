<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카트리스트</title>
</head>
<body>

	<%-- view(jsp)에서 session객체에 접근하는 방법 : ${sessionScope.속성명} --%>
	<%-- view(jsp)에서 request객체에 접근하는 방법 : ${reuqestScope.속성명} or ${속성명}--%>
	

	<h3>${sessionScope.id }님의 카트리스트 (${sessionScope.role })</h3>
	<h5>상품1 : ${cart1 }</h5>
	<h5>상품2 : ${cart2 }</h5>
	<h5>상품3 : ${cart3 }</h5>
	
</body>
</html>